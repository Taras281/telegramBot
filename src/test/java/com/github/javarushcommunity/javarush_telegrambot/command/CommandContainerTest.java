package com.github.javarushcommunity.javarush_telegrambot.command;

import com.github.javarushcommunity.javarush_telegrambot.service.SendBootMesageService;
import com.github.javarushcommunity.javarush_telegrambot.service.TelegramUserServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CommandContainerTest {
    SendBootMesageService sendBootMesageService;
    CommandContainer commandContainer;
    TelegramUserServices tus;
    @BeforeEach
    void init(){
        sendBootMesageService = Mockito.mock(SendBootMesageService.class);
        tus=Mockito.mock(TelegramUserServices.class);
        commandContainer = new CommandContainer(sendBootMesageService, tus);
    }
    @Test
    public void shouldGetAllExistingCommands(){
        Arrays.stream(CommandName.values()).forEach(
                commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(command.getClass(), UncknowCommand.class);
                }
        );
    }
    @Test
    public void shouldGetAllUnknowCommands(){
        Command command = commandContainer.retrieveCommand("ggggg");
        Assertions.assertEquals(UncknowCommand.class, command.getClass());
    }
}