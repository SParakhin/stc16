package ru.innopolis.stc16.innopay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innopay.dao.PaymentRepository;
import ru.innopolis.stc16.innopay.dao.StoreRepository;
import ru.innopolis.stc16.innopay.dto.Payment;
import ru.innopolis.stc16.innopay.dto.ProcessCardRequest;

import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final StoreRepository storeRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(StoreRepository storeRepository, PaymentRepository paymentRepository) {
        this.storeRepository = storeRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment getPayment(String storeName, Long paymentId) {
        ru.innopolis.stc16.innopay.entity.Payment payment;
        try {
            payment = paymentRepository.getPaymentByStore_NameAndCustomPaymentId(storeName, paymentId);
        } catch (Exception e) {
            payment = null;
        }
        if (payment != null) {
            return new ru.innopolis.stc16.innopay.dto.Payment(payment);
        }
        return null;
    }

    @Override
    public Payment createPayment(ProcessCardRequest processRequest) {
        ru.innopolis.stc16.innopay.entity.Payment payment = null;
        if (Math.random() > 0.5) {
            try {
                payment = new ru.innopolis.stc16.innopay.entity.Payment();
                payment.setStore(storeRepository.getStoreByName(processRequest.getStoreName()));
                payment.setCustomPaymentId(processRequest.getCustomPaymentId());
                payment.setDate(new Date());
                String cardNumber = processRequest.getCardNumber();
                String securedCardNumber = cardNumber.substring(0, 6) + "XXXXXX" + cardNumber.substring(12);
                payment.setCardNumber(securedCardNumber);
                payment.setAmount(processRequest.getAmount());
                payment = paymentRepository.save(payment);
            } catch (Exception e) {
                payment = null;
            }
        }
        if (payment != null) {
            return new ru.innopolis.stc16.innopay.dto.Payment(payment);
        }
        return null;
    }
}
