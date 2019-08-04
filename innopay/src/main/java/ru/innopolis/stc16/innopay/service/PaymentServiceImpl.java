package ru.innopolis.stc16.innopay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innopay.dao.PaymentRepository;
import ru.innopolis.stc16.innopay.dto.Payment;
import ru.innopolis.stc16.innopay.entity.Store;

import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
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
    public Payment createPayment(Store store, Long paymentId) {
        ru.innopolis.stc16.innopay.dto.Payment oldPayment = getPayment(store.getName(), paymentId);
        if (oldPayment != null) {
            return oldPayment;
        }
        ru.innopolis.stc16.innopay.entity.Payment payment = null;
        if (Math.random() > 0.5) {
            try {
                payment = new ru.innopolis.stc16.innopay.entity.Payment();
                payment.setStore(store);
                payment.setCustomPaymentId(paymentId);
                payment.setDate(new Date());
                payment.setCardNumber("XXXXXXXXXXXXXXXX");
                payment = paymentRepository.save(payment);
            } catch (Exception e) {
                payment = null;
                e.printStackTrace();
            }
        }
        if (payment != null) {
            return new ru.innopolis.stc16.innopay.dto.Payment(payment);
        }
        return null;
    }
}
