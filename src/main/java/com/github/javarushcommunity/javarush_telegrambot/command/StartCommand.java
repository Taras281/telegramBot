package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.repository.entyti.TelegramUser;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServices;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class StartCommand implements Command {
    SendBootMesageService sendBootMesageService;
    TelegramUserServices telegramUserServices;
    private String startCommand = "Вы отправили комманду СТАРТ";

    public StartCommand(SendBootMesageService sendBootMesageService, TelegramUserServices telegramUserServices) {
        this.sendBootMesageService = sendBootMesageService;
        this.telegramUserServices = telegramUserServices;
    }
    @Override
    public void execute(Update update) throws TelegramApiException {
        String chatId = update.getMessage().getChatId().toString();
        telegramUserServices.findByChatId(chatId).ifPresentOrElse(telegramUser -> {
            telegramUser.setActive(true);
            telegramUserServices.save(telegramUser);
        }, ()->{
                TelegramUser telegramUser = new TelegramUser();
                telegramUser.setActive(true);
                telegramUser.setChatId(chatId);
                telegramUserServices.save(telegramUser);
                }
        );

        sendBootMesageService.execute(chatId, startCommand);
    }
}
