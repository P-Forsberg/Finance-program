package command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import main.Main;

public class Transaction {
    private Main main;
    public ArrayList<TransactionList> salaryList = new ArrayList<>();
    public ArrayList<TransactionList> purchaseList = new ArrayList<>();
    // public ArrayList<Double> dateList = new ArrayList<>();

    public Transaction(Main main) {
        this.main = main;

    }

    public void main(String[] args) {

        Scanner scanner = main.commandHQ.userCommand;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("\nType the command you wish to use:\nDeposite - Salary or banktransfer\nPurchase - item purchased\nbalance - To see your current balance.\nExit - to exit the system");

            String userInput = scanner.nextLine();
            userInput = userInput.toLowerCase();

            switch (userInput) {
                case "deposite":
                    LocalDate salaryDate = null;
                    while (salaryDate == null) {
                        System.out.println("Transaction date (YYYY-MM-DD):");
                        try {
                            String salaryDateStr = scanner.nextLine();
                            salaryDate = LocalDate.parse(salaryDateStr, dateFormat);
                        } catch (DateTimeParseException e) {
                            System.out.println("Wrong date format, use YYYY-MM-DD");
                        }
                    }
                    try {
                        String salaryItem;
                        while (true) {
                            System.out.println("What kind of transfer: ");
                            salaryItem = scanner.nextLine();
                            if (salaryItem.matches("[a-zA-Z ]+")) {
                                break;
                            } else {
                                System.out.println("Invald input, please use letters only!");
                            }
                        }

                        double salaryCount;
                        while (true) {
                            System.out.println("Enter your amount: ");
                            String input = scanner.nextLine();
                            try {
                                salaryCount = Double.parseDouble(input); // försöka parse input till double
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input, use numbers only!");
                            }
                        }

                        salaryList.add(new TransactionList(salaryDate, salaryItem, salaryCount));

                    } catch (DateTimeParseException e) {
                        System.out.println("Wrong date format, use YYYY-MM-DD.\nPlease choose command again ");
                    }
                    break;

                case "purchase":
                    LocalDate purchaseDate = null;
                    while (purchaseDate == null) {
                        System.out.println("Purchase date (YYYY-MM-DD):");
                        try {
                            String purchaseDateStr = scanner.nextLine();
                            purchaseDate = LocalDate.parse(purchaseDateStr, dateFormat);
                        } catch (DateTimeParseException e) {
                            System.out.println("Wrong date format, use YYYY-MM-DD");
                        }

                    }

                    String purchaseItem;
                    while (true) {
                        System.out.println("Enter Item: ");
                        purchaseItem = scanner.nextLine();
                        if (purchaseItem.matches("[a-zA-Z ]+")) {
                            break; // Går ur loopen om input stämmer
                        } else {
                            System.out.println("Invalid input, letters only!");
                        }
                    }

                    double purchaseCount;
                    while (true) {
                        System.out.println("Enter amount: ");
                        String input = scanner.nextLine();
                        try {
                            purchaseCount = Double.parseDouble(input);
                            break; // lämnar loopen om parse lyckas
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input, numbers only!");
                        }
                    }
                    purchaseList.add(new TransactionList(purchaseDate, purchaseItem, purchaseCount));
                    break;

                case "balance":
                    Balance balance = new Balance(main, this);
                    balance.calculateBalance();
                    break;

                case "exit":
                    continueLoop = false;
                    System.out.println("Exiting the transaction system");
                    continue;

                default:
                    System.out.println("Please choose salary, purchase, balance");
                    break;
            }
        }

        System.out.println("Choose new command.");

    }

    // skickar listorna till balance med get
    public ArrayList<TransactionList> getSalaryList() {
        return salaryList;
    }

    public ArrayList<TransactionList> getPurchaseList() {
        return purchaseList;
    }

}
