package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class WheterCommand implements Command {
    RestTemplateBuilder restTemplateBuilder;
    private final TelegramUserServices telegramUserService;
    private final SendBootMesageService sendBotMessageService;

        @Autowired
    public WheterCommand(SendBootMesageService sendBotMessageService, TelegramUserServices telegramUserService) {
            this.sendBotMessageService = sendBotMessageService;
            this.telegramUserService = telegramUserService;
            this.restTemplateBuilder = new RestTemplateBuilder();
    }

    @Override
    public void execute(Update update) throws TelegramApiException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String resp = restTemplate.getForObject("https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,cloud_cover,wind_direction_10m,wind_speed_10m&forecast_hours=24", String.class);
        sendBotMessageService.execute(update.getMessage().getChatId().toString(), resp);

    }
}
