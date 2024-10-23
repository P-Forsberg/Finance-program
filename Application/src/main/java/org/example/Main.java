package org.example;

import org.example.menu.EasyBankMenuM;
import org.example.menu.IBankMenuM;

import java.util.Scanner;


public class Main {
    private IBankMenuM iBankMenuM;

    public Main() {
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
}
