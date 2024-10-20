package com.github.javarushcommunity.javarush_telegrambot.command;

public enum CommandName {
    START("/start"), STOP("/stop"), HELP("/help"), NO("/no"), STAT("/stat"),WHETER("/wheter");

    private String command;

    CommandName(String command) {
        this.command = command;
    }
    public String getCommandName(){
        return command;
    }
}
