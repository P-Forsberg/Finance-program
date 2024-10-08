package main;

import command.CommandHQ;

public class Main{
    public boolean isRunning = true; 
    public CommandHQ commandHQ = new CommandHQ(this);
    public static void main(String[] args) {
        System.out.println("Welcome to finance manager");
        System.out.println("Type 'help' to get the list of commands.");

        Main main = new Main(); 

        while(main.isRunning){
            main.commandHQ.userCommand();
           
        }
    }

}
