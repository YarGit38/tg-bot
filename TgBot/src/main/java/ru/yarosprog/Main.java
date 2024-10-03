package ru.yarosprog;

import ru.yarosprog.bot.TelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws TelegramApiException{
        //создаем переменную, в которой храним экземпляр класса TelegramBotsApi, которпый служит точкой входа нашего бота.
        //DefaultBotSession.class - Это класс, представляющий стандартную конфигурацию сессии бота.
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        //telegramBotsApi.registerBot() - метод класса `TelegramBotsApi`, который регистрирует бота в API
        //new TelegramBot() - Создается новый экземпляр класса `TelegramBot`, который является вашим ботом.
        telegramBotsApi.registerBot(new TelegramBot());
    }
}