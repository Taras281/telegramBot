package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServices;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StopCommand implements Command {
        SendBootMesageService sendBootMesageService;
        TelegramUserServices telegramUserServices;
        private String StopCommand = "Вы отправили комманду СТОП";

        public StopCommand(SendBootMesageService sendBootMesageService, TelegramUserServices telegramUserServices) {
            this.sendBootMesageService = sendBootMesageService;
            this.telegramUserServices = telegramUserServices;
        }
        @Override
        public void execute(Update update) throws TelegramApiException {
            sendBootMesageService.execute(update.getMessage().getChatId().toString(), StopCommand);
            telegramUserServices.findByChatId(update.getMessage().getChatId().toString()).ifPresent(
                    (user)->{user.setActive(false); telegramUserServices.save(user);}
            );
        }
    }

