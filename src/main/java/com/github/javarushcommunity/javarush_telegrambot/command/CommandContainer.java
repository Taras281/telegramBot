package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServices;
import com.google.common.collect.ImmutableMap;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;

public class CommandContainer {

    private  final ImmutableMap<String, Command> commandMap;
    private final UncknowCommand uncknowCommand;

    public CommandContainer(SendBootMesageService sbms, TelegramUserServices tus) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sbms, tus))
                .put(STOP.getCommandName(), new StopCommand(sbms, tus))
                .put(NO.getCommandName(), new NoCommand(sbms))
                .put(HELP.getCommandName(), new HelpCommand(sbms))
                .put(STAT.getCommandName(), new StatCommand(sbms, tus))
                .put(WHETER.getCommandName(), new WheterCommand(sbms, tus))
                .build();
        this.uncknowCommand = new UncknowCommand(sbms);
    }

    public Command retrieveCommand(String commandName){

        return commandMap.getOrDefault(commandName, uncknowCommand);
    }
}
