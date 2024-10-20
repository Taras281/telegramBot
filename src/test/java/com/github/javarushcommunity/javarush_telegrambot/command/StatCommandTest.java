package com.github.javarushcommunity.javarush_telegrambot.command;

import static org.junit.jupiter.api.Assertions.*;

class StatCommandTest extends AstractCommandTest{

    @Override
    com.github.javarushcommunity.javarush_telegrambot.command.Command getCommand() {
        return new StatCommand(sendBootMesageService, telegramUserServices);
    }

    @Override
    String getCommandMessage() {
        return String.format("Javarush Telegram Bot использует %s человек.",0);
    }
}