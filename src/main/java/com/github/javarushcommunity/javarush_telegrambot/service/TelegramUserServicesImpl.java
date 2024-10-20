package com.github.javarushcommunity.javarush_telegrambot.service;

import com.github.javarushcommunity.javarush_telegrambot.repository.entyti.TelegramUser;
import com.github.javarushcommunity.javarush_telegrambot.repository.TelegramUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TelegramUserServicesImpl implements TelegramUserServices {
    private  TelegramUserRepository telegramUserRepository;

    @Autowired
    public TelegramUserServicesImpl(TelegramUserRepository telegramUserRepository) {
        this.telegramUserRepository = telegramUserRepository;
    }
    @Override
    public void save(TelegramUser telegramUser) {
        telegramUserRepository.save(telegramUser);
    }

    @Override
    public List<TelegramUser> rettriveAllActiveUser() {
        return telegramUserRepository.findAllByActiveTrue();
    }

    @Override
    public Optional<TelegramUser> findByChatId(String chatId) {
        return telegramUserRepository.findById(chatId);
    }
}
