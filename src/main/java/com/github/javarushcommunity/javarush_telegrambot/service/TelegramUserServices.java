package com.github.javarushcommunity.javarush_telegrambot.service;

import com.github.javarushcommunity.javarush_telegrambot.repository.entyti.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserServices {
    //метод для сохранения usera
    //метод для получения спска актвных user
    //метод для получения Usera  по chatId

    void save(TelegramUser telegramUser);
    List<TelegramUser> rettriveAllActiveUser();
    Optional<TelegramUser> findByChatId(String chatId);
}
