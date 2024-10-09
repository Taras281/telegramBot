package com.github.javarushcommunity.javarush_telegrambot.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface SendBootMesageService {
    void execute(String chatId, String message) throws TelegramApiException;
}
