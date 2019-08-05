package ru.innopolis.stc16.innopay.service;

import ru.innopolis.stc16.innopay.dto.Payment;
import ru.innopolis.stc16.innopay.dto.ProcessCardRequest;

public interface PaymentService {

    Payment getPayment(String storeName, Long paymentId);

    Payment createPayment(ProcessCardRequest processRequest);
}
