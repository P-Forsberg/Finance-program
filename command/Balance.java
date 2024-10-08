package command;

import main.Main;
import java.util.ArrayList;

public class Balance {
    public Main main;
    public ArrayList<TransactionList> salaryList;
    public ArrayList<TransactionList> purchaseList;

    public Balance(Main main, Transaction transaction) {
        this.main = main;

        // hämtar listorna från transaction
        this.salaryList = transaction.getSalaryList();
        this.purchaseList = transaction.getPurchaseList();

    }

    public void main(String[] parts) {
    }

    public void calculateBalance() {
        double totalSalary = 0;
        double totalPurchase = 0;

        // summera salaryList
        for (TransactionList entry : salaryList) {
            totalSalary += entry.getAmount();
        }
        // sumera purchaselist
        for (TransactionList entry : purchaseList) {
            totalPurchase += entry.getAmount();
        }

        // beräknar balansen
        double sum = totalSalary - totalPurchase;

        System.out.println("Your current balance is: " + sum);

    }

}

