package org.example.command;

public class TransactionCommand extends Command {
    public TransactionCommand(String name, String helper) {
        super("Transaction","Deposit or Withdrawal");
    }

    @Override
    public void execute(String[] commandArgs) {

    }

    // lägg in transaction och spara till fil
    // välja mellan deposite eller withdrawal (1 eller 2)
    //
}
