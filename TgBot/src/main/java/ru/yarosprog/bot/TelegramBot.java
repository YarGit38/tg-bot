package ru.yarosprog.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotToken() { // получение токена, полученного от бота
        return "7561816881:AAFHq9dqhVYisrSOKCJ1CfMMhopjlEq7e_U";
    }

    @Override
    public void onUpdateReceived(Update update) { //обработка сообщений, поступающих в чат бота, путем update - в данном случае отзеркаливание сообщений


        if (update.hasMessage()) {
            String chatId = String.valueOf(update.getMessage().getFrom().getId());// получаем айди чата из апдейта
            String text = update.getMessage().getText(); // получаем текст сообщения из апдейта
            SendMessage sendMessage = new SendMessage(); // объект класса сообщения, отправленного в чат
            sendMessage.setChatId(chatId); // айди чата
            sendMessage.setText(text); // сам текст сообщения

            try {
                this.execute(sendMessage); //обратная отправка в чат телеграмм
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getBotUsername() { // юзернейм, зарегестрированный в боте телеграмм
        return "MemeSu4ki38_bot";
    }
}
