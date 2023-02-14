package io.happyirl.fetishized.commands;

public class RegisterCommandHandler
{
    public void registerCommand(ClientRootCommand clientRootCommand)
    {
        CommandRegistrar registrar = new CommandRegistrar(clientRootCommand);
        registrar.register();
    }
}
