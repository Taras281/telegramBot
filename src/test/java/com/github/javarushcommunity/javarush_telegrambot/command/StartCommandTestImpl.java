package com.github.javarushcommunity.javarush_telegrambot.command;

public class StartCommandTestImpl extends AstractCommandTest {
    @Override
    com.github.javarushcommunity.javarush_telegrambot.command.Command getCommand() {
        return new StartCommand(sendBootMesageService, telegramUserServices);
    }

    @Override
    String getCommandMessage() {
        return "Вы отправили комманду СТАРТ";
    }
}
