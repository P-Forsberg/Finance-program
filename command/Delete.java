package command;

import main.Main;
import java.util.Scanner;
import java.util.ArrayList;

public class Delete {
  public Main main;
  public ArrayList<TransactionList> salaryList;
  public ArrayList<TransactionList> purchaseList;

  public Delete(Main main, Transaction transaction) {
    this.main = main;

    this.salaryList = transaction.getSalaryList();
    this.purchaseList = transaction.getPurchaseList();
  }

  public void main(String[] args) {
    Scanner scannar = main.commandHQ.userCommand;

    boolean continueDelete = true;

    while (continueDelete) {
      System.out.println("Search after transaction: Deposite or Withdrawal \nWhen done type in 'Exit' to leave this funktion.");
      String userInput = scannar.nextLine();
      int userH;

      if (userInput.equalsIgnoreCase("Deposite")) {
        if (salaryList.isEmpty()) {
          System.out.println("There's no deposite to remove.");
          continue;
        } else {
          for (int i = 0; i < salaryList.size(); i++) {
            System.out.println(i + 1 + " " + salaryList.get(i));
          }
          System.out.println("remove a Deposite by index?");
          try {
            userH = scannar.nextInt() - 1;
            scannar.nextLine();
            if (userH < 0 || userH >= salaryList.size()) {
              System.out.println("Invalid index.");
            } else {
              salaryList.remove(userH);
              System.out.println("deposite removed!");
            }
            continue;
          } catch (Exception e) {
            System.out.println("Please enter a valid index");
          }

        }

      }
      
      if (userInput.equalsIgnoreCase("Withdrawal")) {
        if (purchaseList.isEmpty()) {
          System.out.println("There's nothing to remove.");
          continue;
        } else {
          for (int i = 0; i < purchaseList.size(); i++) {
            System.out.println(i + 1 + " " + purchaseList.get(i));
          }
          System.out.println("Remove a Withdrawal/purchase by index?");
          try {
            userH = scannar.nextInt() - 1;
            scannar.nextLine();
            if (userH < 0 || userH >= purchaseList.size()) {
              System.out.println("Invalid index.");
            } else {
              purchaseList.remove(userH);
              System.out.println("deposite removed!");
            }
            continue;
          } catch (Exception e) {
            System.out.println("Please enter a valid index");
          }
        }
      }

      if (userInput.equalsIgnoreCase("Exit")) {
        continueDelete = false;
        System.out.println("Exiting the remove function \nPlease choose a new command");
      } else {
        System.out.println("Wrong input! Choose between Deposite or Withdrawal\n");
      }

    }
  }
}
