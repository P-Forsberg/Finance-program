package org.example.command;

public class RemoveCommand extends Command{

    public RemoveCommand(String name, String helper) {
        super("remove","Remove Transaction");
    }

    @Override
    public void execute(String[] commandArgs) {

    }

    // ta bort fil måste söka blnad depo & with.
}
