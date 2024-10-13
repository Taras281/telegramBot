package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.*;

public class HelpCommand implements Command {
    SendBootMesageService sendBootMesageService;
    private final  String help = String.format("<b>Commands</b>\n" +
                                                        "%s start command \n" +
                                                        "%s stop command \n" +
                                                        "%s help command", START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());
    public HelpCommand(SendBootMesageService sendBootMesageService) {
        this.sendBootMesageService = sendBootMesageService;
    }
    @Override
    public void execute(Update update) throws TelegramApiException {
        sendBootMesageService.execute(update.getMessage().getChatId().toString(), help);
    }
}
