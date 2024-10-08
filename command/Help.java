package command;

import main.Main;

public class Help {
    public Main main;

    public Help(Main main) {
        this.main = main;
    }

    public void main(String[] args) {
        System.out.println("""
                           
                           These are the Commands that will help you navigate through this app: """);
        System.out.println("""
                           
                           Transaction - Register your Salary, a purchase or see your current balance""");
        System.out.println("Remove - Remove a transaction");
        System.out.println("Income - See your overal deposite or search by date");
        System.out.println("Spending - See your overall withdrawal/spending or search by date");
        System.out.println("""
                           Exit - To end the program
                           """);
        System.out.println("Remember to type in the command.");

    }
}
