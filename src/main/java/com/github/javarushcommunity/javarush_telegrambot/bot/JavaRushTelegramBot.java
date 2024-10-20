package com.github.javarushcommunity.javarush_telegrambot.bot;

import com.github.javarushcommunity.javarush_telegrambot.command.CommandContainer;
import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMessageServiceImpl;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServices;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServicesImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

import static com.github.javarushcommunity.javarush_telegrambot.command.CommandName.NO;


@Slf4j
@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";
    @Value("${bot.username}")
    private String nameBot;
    @Value("${bot.token}")
    private String token;
    @PostConstruct
    private void l(){
        log.info("+++ token " + token);
        log.info("+++ nameot " + nameBot);
    }
    private  CommandContainer commandContainer;

    public JavaRushTelegramBot(TelegramUserServices telegramUserServices) {
        this.commandContainer = new CommandContainer(new SendBootMessageServiceImpl(this), telegramUserServices);
    }
    @Override
    public String getBotUsername() {
        return nameBot;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                try {
                    commandContainer.retrieveCommand(commandIdentifier).execute(update);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
