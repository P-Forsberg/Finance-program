package org.example.command;

public class BalanceCommand extends Command {
    public BalanceCommand(String name, String helper) {
        super("balance", "See current balance");
    }

    @Override
    public void execute(String[] commandArgs) {

    }

    //Visa nuvarande balans plusa ihop depo & with.
}
