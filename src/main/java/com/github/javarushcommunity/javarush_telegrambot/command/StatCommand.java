package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMessageServiceImpl;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StatCommand implements Command{
    private final TelegramUserServices telegramUserService;
    private final SendBootMesageService sendBotMessageService;

    public final static String STAT_MESSAGE = "Javarush Telegram Bot использует %s человек.";

    @Autowired
    public StatCommand(SendBootMesageService sendBotMessageService, TelegramUserServices telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }
    @Override
    public void execute(Update update) throws TelegramApiException {
        int numUser = telegramUserService.rettriveAllActiveUser().size();
        sendBotMessageService.execute(update.getMessage().getChatId().toString(), String.format(STAT_MESSAGE, numUser));

    }
}
