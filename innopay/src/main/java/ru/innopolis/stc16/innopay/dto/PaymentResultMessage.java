package ru.innopolis.stc16.innopay.dto;

public enum PaymentResultMessage {
    ALREADY_PAYED("Заказ уже оплачен"),
    ERROR_PAYED("Недостаточно средств"),
    SUCCESS_PAYED("Заказ успешно оплачен");

    private String text;

    PaymentResultMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
