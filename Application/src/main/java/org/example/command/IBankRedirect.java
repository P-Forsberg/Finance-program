package org.example.command;

public interface IBankRedirect {

    void registerCommand(Command command);
    void tryExecuteCommand(String input);
}
