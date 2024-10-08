package command;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.InputMismatchException;

import main.Main;

public class Spending {
    public Main main;
    private ArrayList<TransactionList> purchaseList;

    public Spending(Main main, Transaction transaction) {
        this.main = main;
        this.purchaseList = transaction.getPurchaseList();
    }

    public void main(String[] args) {

        Scanner scanner = main.commandHQ.userCommand;
        boolean isIncome = true;

        while (isIncome) {
            System.out.println("Choose to view your Withdrawal/spending:");
            System.out.println("Yearly \nMonthly \nWeekly \nDaily \nOverall \nExit");

            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "yearly":
                    int year = getValidYear(scanner);
                    printYearlyTransactions(year);
                    break;

                case "monthly":
                    year = getValidYear(scanner);
                    int month = getValidMonth(scanner);
                    printMonthlyTransactions(year, month);
                    break;

                case "weekly":
                    year = getValidYear(scanner);
                    int week = getValidWeek(scanner);
                    printWeeklyTransactions(year, week);
                    break;

                case "daily":
                    year = getValidYear(scanner);
                    month = getValidMonth(scanner);
                    int day = getValidDay(scanner, year, month);
                    printDailyTransactions(year, month, day);
                    break;

                case "overall":
                    printOverallTransactions();
                    break;

                case "exit":
                    isIncome = false;
                    System.out.println(
                            "Exiting Income Function. \nPlease choose a new command, type 'help' to view the commands.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid command.");
                    break;
            }
        }
    }

    // En hjälp metod som validerar år via en while loop
    private int getValidYear(Scanner scanner) {
        int currentYear = LocalDate.now().getYear();
        int year = -1;
        while (year == -1) {
            System.out.println("Enter Year:");
            try {
                year = scanner.nextInt();
                scanner.nextLine();
                if (year <= 0 || year > currentYear) {
                    System.out.println("Invalid year. Please enter a valid year (up to " + currentYear + ").");
                    year = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.nextLine();
            }
        }
        return year;
    }

    // En hjälp metod som validerar månad via en while loop
    private int getValidMonth(Scanner scanner) {
        int month = -1;
        while (month == -1) {
            System.out.println("Enter Month (1-12):");
            try {
                month = scanner.nextInt();
                scanner.nextLine();
                if (month < 1 || month > 12) {
                    System.out.println("Invalid month. Please enter a month between 1 and 12.");
                    month = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid month.");
                scanner.nextLine();
            }
        }
        return month;
    }

    // En hjälp metod som validerar år via en while loop
    private int getValidWeek(Scanner scanner) {
        int week = -1;
        while (week == -1) {
            System.out.println("Enter Week (1-52):");
            try {
                week = scanner.nextInt();
                scanner.nextLine();
                if (week < 1 || week > 52) {
                    System.out.println("Invalid week. Please enter a week between 1 and 52.");
                    week = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid week.");
                scanner.nextLine();
            }
        }
        return week;
    }

    // Hjälp method som hämtar giltig dag med while loop med åtanke på år och månad.
    private int getValidDay(Scanner scanner, int year, int month) {
        int day = -1;
        while (day == -1) {
            System.out.println("Enter Day (1-31):");
            try {
                day = scanner.nextInt();
                scanner.nextLine();
                // Validerar dagen för specifik år och månad genom LocalDate
                try {
                    LocalDate.of(year, month, day); // kommer kasta en exception om date är ogiltig
                } catch (DateTimeException e) {
                    System.out.println("Invalid day. Please enter a valid day for the given month and year.");
                    day = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid day.");
                scanner.nextLine();
            }
        }
        return day;
    }

    /*
     * Beroende på användarens input så skrivs ut summan antingen per år, år-vecak,
     * år-månad,
     * år-månad-dag eller den totala summan.
     */
    public void printYearlyTransactions(int year) {
        double sum = 0;
        System.out.println("Withdrawal/spending for the year " + year + ":");
        for (TransactionList entry : purchaseList) {
            if (entry.getDate().getYear() == year) {
                System.out.println(entry);
                sum += entry.getAmount();
            }
        }
        System.out.println("Total for " + year + ": " + sum);
    }

    public void printMonthlyTransactions(int year, int month) {
        double sum = 0;
        System.out.println("Withdrawal/spending for the " + year + "-" + month + ":");
        for (TransactionList entry : purchaseList) {
            LocalDate date = entry.getDate();
            if (date.getYear() == year && date.getMonthValue() == month) {
                System.out.println(entry);
                sum += entry.getAmount();
            }
        }
        System.out.println("Total for " + year + "-" + month + ": " + sum);

    }

    public void printWeeklyTransactions(int year, int week) {
        double sum = 0;
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        System.out.println("Withdrawal/spending for year " + year + ", week " + week);
        for (TransactionList entry : purchaseList) {
            LocalDate date = entry.getDate();
            int entryWeek = date.get(weekFields.weekOfYear());
            if (date.getYear() == year && entryWeek == week) {
                System.out.println(entry);
                sum += entry.getAmount();
            }
        }
        System.out.println("Total for year " + year + ", week " + week + ": " + sum);
    }

    public void printDailyTransactions(int year, int month, int day) {
        double sum = 0;
        System.out.println("Withdrawal/spending for " + year + "-" + month + "-" + day);
        for (TransactionList entry : purchaseList) {
            LocalDate date = entry.getDate();
            if (date.getYear() == year && date.getMonthValue() == month
                    && entry.getDate().getDayOfMonth() == day) {
                System.out.println(entry);
                sum += entry.getAmount();
            }
        }
        System.out.println("Total for " + year + "-" + month + "-" + day + ": " + sum);

    }

    public void printOverallTransactions() {
        double sum = 0;
        Collections.sort(purchaseList);
        System.out.println("Withdrawal/spending sorted by date: ");
        for (TransactionList entry : purchaseList) {
            System.out.println(entry);
            sum += entry.getAmount();
        }
        System.out.println("Your total Withdrawal/spending is: " + sum);
    }
}
