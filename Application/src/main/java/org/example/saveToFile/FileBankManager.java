package org.example.saveToFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileBankManager implements IBankManager {

    @Override
    public void save(Bank bank) {
        File folder = new File("./bank");
        folder.mkdirs();

        File file = new File(folder, bank.title);
        try{
            file.createNewFile();
            //append för att lägga till data i samma fil
            FileWriter writer = new FileWriter(file, true);

            writer.append("\n----\n");

            writer.append(bank.title)
                    .append(" ")
                    .append(bank.date)
                    .append(" ")
                    .append(bank.description)
                    .append(" ")
                    .append(String.valueOf(bank.currency));
            writer.flush();
            writer.close();
        } catch(Exception e){
            e.printStackTrace();
            return;
        }


    }

    @Override
    public void remove(Bank bank) {
        File folder = new File("./bank");
        if(!folder.exists())
            return;
        File file = new File(folder, bank.title);
        if(!folder.exists())
            return;

        file.delete();

    }

    @Override
    public Bank getByTitle(String title) {
        File folder = new File("./bank");
        if(!folder.exists())
            return null;

        File file= new File(folder, title);
        if(!folder.exists())
            return null;

        try{
            FileReader reader = new FileReader(file);
            BufferedReader buffered = new BufferedReader(reader);

            Bank bank = new Bank();
            bank.date = buffered.readLine();
            bank.title = buffered.readLine();
            bank.description = buffered.readLine();
            bank.currency = Integer.parseInt(buffered.readLine());

            buffered.close();

            return bank;
        } catch (Exception e){
            return null;
        }
    }
}
