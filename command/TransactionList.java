package command;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class TransactionList implements Comparable<TransactionList> {
    private LocalDate date;
    private String item;
    private double amount;

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public TransactionList(LocalDate date, String item, double amount) {
        this.date = date;
        this.amount = amount;
        this.item = item;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getItem() {
        return item;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Date: " + date.format(dateFormatter) + ", Item: " + item + ", Amount: " + amount;
    }

    // implementera jämförelser baserat på datum
    @Override
    public int compareTo(TransactionList other) {
        return this.date.compareTo(other.getDate());
    }
}
