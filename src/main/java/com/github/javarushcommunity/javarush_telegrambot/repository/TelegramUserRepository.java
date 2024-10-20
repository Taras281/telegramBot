package com.github.javarushcommunity.javarush_telegrambot.repository;

import com.github.javarushcommunity.javarush_telegrambot.repository.entyti.TelegramUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelegramUserRepository extends CrudRepository<TelegramUser, String> {
    List<TelegramUser> findAllByActiveTrue();
}
