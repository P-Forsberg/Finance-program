package org.example.command;

public abstract class Command {
    private String name;
    private String helper;
    //app?

    public Command(String name, String helper){
        this.name = name;
        this.helper = helper;

        //app?
    }

    public abstract void execute(String[] commandArgs);

    public String getName() {
        return name;
    }

    public String getHelper() {
        return helper;
    }
}
