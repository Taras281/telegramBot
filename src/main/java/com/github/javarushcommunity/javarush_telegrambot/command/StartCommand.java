package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class StartCommand implements Command {
    SendBootMesageService sendBootMesageService;
    private String startCommand = "Вы отправили комманду СТАРТ";

    public StartCommand(SendBootMesageService sendBootMesageService) {
        this.sendBootMesageService = sendBootMesageService;
    }
    @Override
    public void execute(Update update) throws TelegramApiException {
        sendBootMesageService.execute(update.getMessage().getChatId().toString(), startCommand);
    }
}
