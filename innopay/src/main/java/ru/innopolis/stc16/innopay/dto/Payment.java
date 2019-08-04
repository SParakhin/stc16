package ru.innopolis.stc16.innopay.dto;

import lombok.Data;

import java.util.Date;

/**
 * DTO "Заказ"
 */
@Data
public class Payment {

    private String storeName;
    private Long customPaymentId;
    private Date date;
    private String cardNumber;

    public Payment(ru.innopolis.stc16.innopay.entity.Payment payment) {
        this.storeName = payment.getStore().getName();
        this.customPaymentId = payment.getCustomPaymentId();
        this.date = payment.getDate();
        this.cardNumber = payment.getCardNumber();
    }
}
