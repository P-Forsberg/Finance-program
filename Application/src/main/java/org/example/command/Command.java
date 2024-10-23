package org.example.command;

import org.example.Main;

public abstract class Command {
    private String name;
    private String helper;
    protected Main main;

    public Command(String name, String helper, Main main){
        this.name = name;
        this.helper = helper;
        this.main = main;
    }

    public abstract void execute(String[] commandArgs);

    public String getName() {
        return name;
    }

    public String getHelper() {
        return helper;
    }
}
