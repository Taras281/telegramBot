package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class NoCommand implements Command {
    private String no = "Вы отправили команду без слеша /";
    SendBootMesageService sendBootMesageService;
    public NoCommand(SendBootMesageService sendBootMesageService) {
        this.sendBootMesageService = sendBootMesageService;
    }

    @Override
    public void execute(Update update) throws TelegramApiException {
        sendBootMesageService.execute(update.getMessage().getChatId().toString(), no);

    }
}
