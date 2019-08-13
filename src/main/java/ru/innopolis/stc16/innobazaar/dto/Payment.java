package ru.innopolis.stc16.innobazaar.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO "Оплата"
 */
@Data
public class Payment {

    private String storeName;
    private Date date;
    private String cardNumber;
    private BigDecimal amount;

}
