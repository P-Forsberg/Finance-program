package org.example;

public class EasyBankMenuM implements IBankMenuM {

    private BankMenu bankMenu;

    public EasyBankMenuM(Main main){
        this.bankMenu = new UserBankMenu(main);
        this.bankMenu.display();
    }

    @Override
    public void setMenu(BankMenu bankMenu) {
        this.bankMenu = bankMenu;
        bankMenu.display();
    }

    @Override
    public BankMenu getCurrentMenu(){
        return bankMenu;
    }
}
