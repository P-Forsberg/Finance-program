package org.example.command;

import org.example.Main;

public class RemoveCommand extends Command{

    public RemoveCommand(Main main) {
        super("Remove","Remove Transaction", main);
    }

    @Override
    public void execute(String[] commandArgs) {
        System.out.println("hej");
    }

    // ta bort fil måste söka blnad depo & with.
}
