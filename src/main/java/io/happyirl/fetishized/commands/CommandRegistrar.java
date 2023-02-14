package io.happyirl.fetishized.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.command.CommandRegistryAccess;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class CommandRegistrar {

    private final ClientRootCommand clientRootCommand;

    public CommandRegistrar(ClientRootCommand clientRootCommand)
    {
        this.clientRootCommand = clientRootCommand;
        register();
    }

    public void register()
    {
        ClientCommandRegistrationCallback.EVENT.register(this::registerRootCommandToDispatcher);
    }

    private void registerRootCommandToDispatcher(CommandDispatcher<FabricClientCommandSource> dispatcher, CommandRegistryAccess registryAccess)
    {
        //Register the context from the LiteralArgumentBuilder of the clientCommandBuilder
        LiteralCommandNode<FabricClientCommandSource> rootCommandNode =
                dispatcher.register(getContextForArgumentBuilder(getLiteralArgumentBuilderForClientCommand(clientRootCommand), clientRootCommand));

        registerRootAliases(rootCommandNode, dispatcher);
    }

    private void registerRootAliases(LiteralCommandNode<FabricClientCommandSource> rootCommandNode, CommandDispatcher<FabricClientCommandSource> dispatcher)
    {
        String[] aliases = clientRootCommand.getAliases();

        if(aliases != null)
        {
            for(String alias : aliases)
                dispatcher.register(getLiteralArgumentBuilderForString(alias).redirect(rootCommandNode));
        }
    }

    private LiteralArgumentBuilder<FabricClientCommandSource> getLiteralArgumentBuilderForString(String s)
    {
        return ClientCommandManager.literal(getFormattedName(s));
    }

    private LiteralArgumentBuilder<FabricClientCommandSource> getLiteralArgumentBuilderForClientCommand(ClientCommand command)
    {
        return literal(getFormattedName(command.getCommandName()));
    }

    private String getFormattedName(String s)
    {
        return s.replaceAll("\\s","");
    }

    //since LiteralArgumentBuilder.then() always returns itself, no need to create new instance copies
    LiteralArgumentBuilder<FabricClientCommandSource> getContextForArgumentBuilder(LiteralArgumentBuilder<FabricClientCommandSource> literalArgumentBuilder, ClientCommand command)
    {
        literalArgumentBuilder.executes(command::executeCommandContext);

        linkSubcommands(literalArgumentBuilder, command);

        return literalArgumentBuilder;
    }

    //since LiteralArgumentBuilder.then() always returns itself, no need to return a new LiteralArgumentBuilder
    private void linkSubcommands(LiteralArgumentBuilder<FabricClientCommandSource> modifiedLiteralArgumentBuilder, ClientCommand command)
    {
        ClientSubCommand[] clientSubCommands = command.getSubCommands();

        if(clientSubCommands != null)
            for (ClientSubCommand subCommand : clientSubCommands)
            {
                modifiedLiteralArgumentBuilder.then(getContextForArgumentBuilder(getLiteralArgumentBuilderForClientCommand(subCommand), subCommand));

                LiteralCommandNode<FabricClientCommandSource> commandNode  = modifiedLiteralArgumentBuilder.build();
            }
    }
}
