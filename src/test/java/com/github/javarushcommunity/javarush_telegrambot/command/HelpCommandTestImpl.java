package com.github.javarushcommunity.javarush_telegrambot.command;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;

public class HelpCommandTestImpl extends AstractCommandTest {
    @Override
    com.github.javarushcommunity.javarush_telegrambot.command.Command getCommand() {
        return new HelpCommand(sendBootMesageService);
    }

    @Override
    String getCommandMessage() {
        return String.format("<b>Commands</b>\n" +
                "%s start command \n" +
                "%s stop command \n" +
                "%s help command", START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());
    }
}
