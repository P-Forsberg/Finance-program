package org.example;

import org.example.saveToFile.IBankManager;

import java.util.Scanner;

public class Main{
    private IBankMenuM iBankMenuM;
    private IBankManager iBankManager;

    public Main(){
        this.iBankMenuM = new EasyBankMenuM(this);
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        while(true){
            main.getIBankMenuM().getCurrentMenu().tryExecuteCommand(scanner.nextLine());
        }
    }


    public IBankMenuM getIBankMenuM() {
         return iBankMenuM;
        }

    public IBankManager getiBankManager() {
        return iBankManager;
    }
}
