package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.bot.JavaRushTelegramBot;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AstractCommandTest {
    SendBootMesageService sendBootMesageService;
    JavaRushTelegramBot javaRushTelegramBot;
    Command Command;
    abstract Command getCommand();

    abstract String getCommandMessage();

    @BeforeEach
    void setUp() {
        javaRushTelegramBot = Mockito.mock(JavaRushTelegramBot.class);
        sendBootMesageService = new SendBootMessageServiceImpl(javaRushTelegramBot);
        Command = new StartCommand(sendBootMesageService);
    }
    @Test
    public void should(){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(111L);
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        Update update =new Update();
        Message message = Mockito.mock(Message.class);
        update.setMessage(message);
        Mockito.when(update.getMessage().getChatId()).thenReturn(111l);
        Mockito.when(update.getMessage().getText()).thenReturn(getCommandMessage());


        //when

        try {
            getCommand().execute(update);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        //then
        try {
            Mockito.verify(javaRushTelegramBot).execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }


}