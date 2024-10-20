package com.github.javarushcommunity.javarush_telegrambot.repository;

import com.github.javarushcommunity.javarush_telegrambot.repository.entyti.TelegramUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TelegramUserRepositoryIT {
    TelegramUserRepository telegramUserRepository;

    @Autowired
    TelegramUserRepositoryIT(TelegramUserRepository telegramUserRepository){
        this.telegramUserRepository = telegramUserRepository;
    }

    @Test
    @Sql(scripts = {"/sql/delit_all.sql", "/sql/insert_users.sql"})
    void findAllByActiveTrue() {
        Assertions.assertEquals(5, telegramUserRepository.findAllByActiveTrue().size());
    }
    @Test
    void saveInBase(){
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setActive(true);
        telegramUser.setChatId("123456789");
        telegramUserRepository.save(telegramUser);

        Optional<TelegramUser> userFromBase = telegramUserRepository.findById(telegramUser.getChatId());
        Assertions.assertTrue(userFromBase.isPresent());
        Assertions.assertEquals(telegramUser, userFromBase.get());
    }

}