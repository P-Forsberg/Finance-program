package command;

import main.Main;

public class Quit {
    public Main main;

    public Quit(Main main) {
        this.main = main;
    }

    public void main(String[] args) {
        main.isRunning = false;
    }
}
