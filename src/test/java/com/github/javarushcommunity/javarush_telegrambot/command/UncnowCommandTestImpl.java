package com.github.javarushcommunity.javarush_telegrambot.command;

public class UncnowCommandTestImpl extends AstractCommandTest {
    @Override
    com.github.javarushcommunity.javarush_telegrambot.command.Command getCommand() {
        return new UncknowCommand(sendBootMesageService);
    }

    @Override
    String getCommandMessage() {
        return "Вы отправили неизвестную команду отправте /help";
    }
}
