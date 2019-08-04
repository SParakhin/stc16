package ru.innopolis.stc16.innopay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc16.innopay.dto.Payment;
import ru.innopolis.stc16.innopay.dto.Store;
import ru.innopolis.stc16.innopay.service.PaymentService;
import ru.innopolis.stc16.innopay.service.StoreService;

@Controller
@RequestMapping("/payments")
public class PaymentController {

    private final StoreService storeService;
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(StoreService storeService, PaymentService paymentService) {
        this.storeService = storeService;
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/getPayment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Payment> getPayment(@RequestParam("id") Long paymentId, @RequestBody Store store) {
        if (!storeService.authorize(store.getName(), store.getSecretKey())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Payment payment = paymentService.getPayment(store.getName(), paymentId);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping(path = "/createPayment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Payment> createPayment(@RequestParam("id") Long paymentId, @RequestBody Store store) {
        ru.innopolis.stc16.innopay.entity.Store authorizedStore = storeService.authorizeGet(store.getName(), store.getSecretKey());
        if (authorizedStore == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Payment payment = paymentService.createPayment(authorizedStore, paymentId);
        if (payment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
