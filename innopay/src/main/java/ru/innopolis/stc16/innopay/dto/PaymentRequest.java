package ru.innopolis.stc16.innopay.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {

    private String storeName;
    private String secretKey;
    private Long customPaymentId;
    private BigDecimal amount;
    private String returnPage;
}
