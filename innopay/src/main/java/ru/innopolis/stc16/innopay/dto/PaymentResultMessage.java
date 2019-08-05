package ru.innopolis.stc16.innopay.dto;

public enum PaymentResultMessage {
    ALREADY_PAYED("Заказ уже оплачен"),
    ERROR_PAYED("Произошла ошибка при оплате заказа"),
    SUCCESS_PAYED("Заказ успешно оплачен");

    private String text;

    PaymentResultMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
