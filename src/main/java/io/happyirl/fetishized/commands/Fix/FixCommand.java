package io.happyirl.fetishized.commands.Fix;

import com.mojang.brigadier.context.CommandContext;
import io.happyirl.fetishized.commands.ClientRootCommand;
import io.happyirl.fetishized.commands.ClientSubCommand;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.text.Text;

public class FixCommand implements ClientRootCommand
{
    private String name = "fix";
    private ClientSubCommand[] clientSubCommands;

    public FixCommand(ClientSubCommand[] clientSubCommands)
    {
        if(clientSubCommands == null && clientSubCommands.length == 0)
            return;

        this.clientSubCommands = clientSubCommands;
    }

    @Override
    public String getCommandName()
    {
        return name;
    }

    public String[] getAliases()
    {
        return new String[]{"f"};
    }

    @Override
    public int executeCommandContext(CommandContext<FabricClientCommandSource> context)
    {
        context.getSource().sendFeedback(Text.of("Usage: /fix [args]. List of args: Gamemode"));

        return 1;
    }

    @Override
    public ClientSubCommand[] getSubCommands()
    {
        return clientSubCommands;
    }
}
