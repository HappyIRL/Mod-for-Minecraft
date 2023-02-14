package io.happyirl.fetishized;

import io.happyirl.fetishized.commands.ClientSubCommand;
import io.happyirl.fetishized.commands.Fix.FixCommand;
import io.happyirl.fetishized.commands.Fix.FixGamemodeCommand;
import io.happyirl.fetishized.commands.RegisterCommandHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fetishized implements ModInitializer {
	public static final String MOD_ID = "fetishized";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	RegisterCommandHandler commandHandler = new RegisterCommandHandler();
	FixGamemodeCommand fixGamemodeCommand = new FixGamemodeCommand();
	FixCommand fixCommand = new FixCommand(new ClientSubCommand[]{fixGamemodeCommand});


	@Override
	public void onInitialize()
	{
		registerEvents();
	}

	private void registerEvents()
	{
		commandHandler.registerCommand(fixCommand);
	}
}
