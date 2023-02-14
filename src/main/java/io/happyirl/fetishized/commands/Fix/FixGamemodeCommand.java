package io.happyirl.fetishized.commands.Fix;

import com.mojang.brigadier.context.CommandContext;
import io.happyirl.fetishized.commands.ClientSubCommand;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.world.GameMode;

public class FixGamemodeCommand implements ClientSubCommand
{
    private String name = "Gamemode";

    @Override
    public int executeCommandContext(CommandContext<FabricClientCommandSource> context)
    {
        MinecraftClient.getInstance().interactionManager.setGameMode(GameMode.SURVIVAL);

        context.getSource().sendFeedback(Text.of("Gamemode fixed!"));

        return 1;
    }

    @Override
    public ClientSubCommand[] getSubCommands()
    {
        return null;
    }

    @Override
    public String getCommandName()
    {
        return name;
    }
}
