package io.happyirl.fetishized.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;

public interface ClientCommand
{
    /**
     * Represents a command executor, where the command logic is defined.
     * The CommandContext parameter contains information about the command being executed, such as the source of the command,
     * the arguments passed to the command, etc.
     * The FabricClientCommandSource is a type of command source that represents the command being executed on the client-side of the game.
     * @return integer status code to indicate whether the command execution was successful or not.
     * A return value of 1 indicates success, see: https://docproject.github.io/mojang_brigadier/com/mojang/brigadier/Command.html.
     */
    int executeCommandContext(CommandContext<FabricClientCommandSource> context);

    /**
     * Represents an array of sub-commands associated with a main-command.
     * Sub-commands are additional commands that can be executed as part of the main command and provide additional information or options.
     * For example, a main command of "/spawn" might have sub-commands "/spawn mob" and "/spawn item".
     * Recommended to create a new class implementing ClientCommand for each sub-command.
     * @return ClientCommand array. Return null if there are no sub-commands.
     */
    ClientSubCommand[] getSubCommands();

    /**
     * Represents a raw part of the string used in game to call the command.
     * For example if returned "spawn" as main-command it would be "/spawn", as sub-command '/mainCmd "spawn"'.
     * Note: Anything that is a space character (including tab characters, non-visible characters, etc.) will be removed.
     * @return String, the in-game name of the command.
     */
    String getCommandName();
}
