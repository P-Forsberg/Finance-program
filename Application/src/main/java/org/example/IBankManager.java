package org.example;

public interface IBankManager {
    void save(Bank bank);
    void remove(Bank bank);
    Bank getByTitle(String title);
}
