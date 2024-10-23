package org.example.menu;

import org.example.Main;
import org.example.command.Command;
import org.example.command.IBankRedirect;

import java.util.ArrayList;
import java.util.List;

public abstract class BankMenu implements IBankRedirect {

    private List<Command> commands = new ArrayList<>();
    protected Main main;

    public BankMenu(Main main){
        this.main = main;
    }

    public abstract void display();

    @Override
    public void registerCommand(Command command) {
        this.commands.add(command);
    }

    @Override
    public void tryExecuteCommand(String input) {
        if(input.isBlank())
            throw new IllegalArgumentException("Input must not be empty.");

        //Enklare sätt att få in help på!
        if(input.equalsIgnoreCase("help")){
            for (Command command : commands){
                System.out.println(command.getName() + " - " + command.getHelper());
            }

            return;
        }

        String[] commandArgs = input.split(" ");
        String commandName = commandArgs[0];

        for (Command command : commands){
            if (command.getName().equalsIgnoreCase(commandName)){
                command.execute(commandArgs);
                return;
            }
        }
    }
}
