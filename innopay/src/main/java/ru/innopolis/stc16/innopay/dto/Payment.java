package ru.innopolis.stc16.innopay.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO "Заказ"
 */
@Data
public class Payment {

    private String storeName;
    private Date date;
    private String cardNumber;
    private BigDecimal amount;

    public Payment(ru.innopolis.stc16.innopay.entity.Payment payment) {
        this.storeName = payment.getStore().getName();
        this.date = payment.getDate();
        this.cardNumber = payment.getCardNumber();
        this.amount = payment.getAmount();
    }
}
