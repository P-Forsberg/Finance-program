package org.example.saveToFile;

import java.util.ArrayList;
import java.util.List;

public class BankListManager implements IBankManager {

    private List<Bank> banks = new ArrayList<>();

    @Override
    public void save(Bank bank) {
        banks.add(bank);
    }

    @Override
    public void remove(Bank bank) {
        banks.remove(bank);
    }

    @Override
    public Bank getByTitle(String title) {
        for (Bank bank : banks){
            if(bank.title.equalsIgnoreCase(title)){
                return bank;
            }
        }

        return null;
    }
}
