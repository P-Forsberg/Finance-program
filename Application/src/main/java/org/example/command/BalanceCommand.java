package org.example.command;

import org.example.Main;

public class BalanceCommand extends Command {
    public BalanceCommand(Main main) {
        super("Balance", "See current balance", main);
    }


    @Override
    public void execute(String[] commandArgs) {

    }

    //Visa nuvarande balans plusa ihop depo & with.
}
