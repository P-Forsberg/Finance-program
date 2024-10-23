package org.example.command;

import org.example.Main;

public class TransactionCommand extends Command {
    public TransactionCommand(Main main) {
        super("Transaction","Deposit or Withdrawal", main);
    }



    @Override
    public void execute(String[] commandArgs) {
        System.out.println("hej");
    }

    // lägg in transaction och spara till fil
    // välja mellan deposite eller withdrawal (1 eller 2)
    //
}
