package ru.innopolis.stc16.innopay.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc16.innopay.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Payment getPaymentByStore_NameAndCustomPaymentId(String storeName, Long paymentId);
}
