package org.example;

import org.example.command.BalanceCommand;
import org.example.command.RemoveCommand;
import org.example.command.TransactionCommand;
import org.example.command.ViewCurrencyCommand;

public class UserBankMenu extends BankMenu {

    public UserBankMenu(Main main){
        super(main);
        registerCommand(new BalanceCommand(main));
        registerCommand(new RemoveCommand(main));
        registerCommand(new ViewCurrencyCommand(main));
        registerCommand(new TransactionCommand(main));
    }


    @Override
    public void display() {
        System.out.println("Welcome to the Bank application! To view the commands type 'help'");
    }
}
