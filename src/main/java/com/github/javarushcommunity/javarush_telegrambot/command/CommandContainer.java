package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.google.common.collect.ImmutableMap;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;

public class CommandContainer {

    private  final ImmutableMap<String, Command> commandMap;
    private final UncknowCommand uncknowCommand;

    public CommandContainer(SendBootMesageService sbms) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sbms))
                .put(STOP.getCommandName(), new StopCommand(sbms))
                .put(NO.getCommandName(), new NoCommand(sbms))
                .build();
        this.uncknowCommand = new UncknowCommand(sbms);
    }

    public Command retrieveCommand(String commandName){
        return commandMap.getOrDefault(commandName, uncknowCommand);
    }
}
