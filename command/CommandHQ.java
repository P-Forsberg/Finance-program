package command;

import java.util.Scanner;

import main.Main;

public class CommandHQ {

    public Scanner userCommand;
    public Transaction transactionCommand;
    private Delete deleteCommand;
    private Spending spendingCommand;
    public Income incomeCommand;
    private Help helpCommand;
    private Quit quitCommand;

    public CommandHQ(Main main) {

        transactionCommand = new Transaction(main);
        deleteCommand = new Delete(main, transactionCommand);
        spendingCommand = new Spending(main, transactionCommand);
        incomeCommand = new Income(main, transactionCommand);
        helpCommand = new Help(main);
        quitCommand = new Quit(main);
        userCommand = new Scanner(System.in);
    }

    public void userCommand() {
        // läser in kommandot från användare
        String input = userCommand.nextLine();

        String[] parts = input.split(" ");
        if (parts.length == 0) {
            throw new IllegalArgumentException("Tomt kommando");
        }
        String command = parts[0];

        switch (command) {
            case "transaction":
                transactionCommand.main(parts);
                break;
            case "spending":
                spendingCommand.main(parts);
                break;
            case "income":
                incomeCommand.main(parts);
                break;
            case "remove":
                deleteCommand.main(parts);
                break;
            case "help":
                helpCommand.main(parts);
                break;
            case "exit":
                quitCommand.main(parts);
                break;
            default:
                System.out.println("Not valid command " + command + ", type help to view all the commands");
                break;
        }

    }
}