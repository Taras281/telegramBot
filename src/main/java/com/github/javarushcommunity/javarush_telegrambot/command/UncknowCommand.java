package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UncknowCommand implements Command {
    SendBootMesageService sendBootMesageService;
    public UncknowCommand(SendBootMesageService sendBootMesageService) {
        this.sendBootMesageService = sendBootMesageService;
    }


    @Override
    public void execute(Update update) throws TelegramApiException {
        sendBootMesageService.execute(update.getMessage().getChatId().toString(), "Вы отправили неизвестную команду отправте /help");
    }
}
