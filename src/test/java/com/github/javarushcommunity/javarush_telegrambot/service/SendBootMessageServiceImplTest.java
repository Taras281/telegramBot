package com.github.javarushcommunity.javarush_telegrambot.service;

import com.github.javarushcommunity.javarush_telegrambot.bot.JavaRushTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;

class SendBootMessageServiceImplTest {
    JavaRushTelegramBot javaRushTelegramBot;
    SendBootMessageServiceImpl sendBootMessageService;
    @BeforeEach
    void setUp() {
        javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);
        sendBootMessageService = new SendBootMessageServiceImpl(javaRushTelegramBot);
    }

    @Test
    void execute() throws TelegramApiException {
        //Метод verify  проверяет запустит ли наш сервис javaRushTelegramBot метод execute c созданнымитпараметрами
        //given
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId("asdf");
        sendMessage.setText("message");
        sendMessage.enableHtml(true);
        //when когда мы запустим метод sendBootMessageService.execute
        sendBootMessageService.execute("asdf", "message");
        // тогда javaRushTelegramBot выполнит метод execute(sendMessage)
        Mockito.verify(javaRushTelegramBot).execute(sendMessage);

    }
}