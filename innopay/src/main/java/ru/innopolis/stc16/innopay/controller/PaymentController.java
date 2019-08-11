package ru.innopolis.stc16.innopay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc16.innopay.dto.*;
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

    /**
     * получить информацию об оплате
     *
     * @param paymentId идентификатор заказа
     * @param store     credentials магазина
     * @return платёж
     */
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

    /**
     * запрос на проведение платежа
     *
     * @param paymentRequest тело запроса
     * @param model          модель
     * @return страницу для ввода данных платёжной карты
     */
    @PostMapping(path = "/createPayment")
    public String createPayment(PaymentRequest paymentRequest, Model model) {
        if (!storeService.authorize(paymentRequest.getStoreName(), paymentRequest.getSecretKey())) {
            throw new NotAuthorizedException();
        }
        Payment payment = paymentService.getPayment(paymentRequest.getStoreName(), paymentRequest.getCustomPaymentId());
        if (payment != null) {
            PaymentResult paymentResult = new PaymentResult();
            paymentResult.setReturnPage(paymentRequest.getReturnPage());
            paymentResult.setResult(PaymentResultMessage.ALREADY_PAYED.getText());
            model.addAttribute("paymentResult", paymentResult);
            return "paymentResult";
        }
        model.addAttribute("payment", paymentRequest);
        return "processCard";
    }

    /**
     * обрабатывает платёж по карте
     *
     * @param processRequest тело запроса
     * @param model          модель
     * @return результат оплаты
     */
    @PostMapping(path = "/processPayment")
    public String processPayment(ProcessCardRequest processRequest, Model model) {
        if (!storeService.authorize(processRequest.getStoreName(), processRequest.getSecretKey())) {
            throw new NotAuthorizedException();
        }
        PaymentResult paymentResult = new PaymentResult();
        paymentResult.setReturnPage(processRequest.getReturnPage());
        Payment payment = paymentService.createPayment(processRequest);
        if (payment == null) {
            paymentResult.setResult(PaymentResultMessage.ERROR_PAYED.getText());
        } else {
            paymentResult.setResult(PaymentResultMessage.SUCCESS_PAYED.getText());
        }
        model.addAttribute("paymentResult", paymentResult);
        return "paymentResult";
    }

    /**
     * возврат на торговую площадку
     *
     * @param returnPage URL для возврата
     * @return редирект
     */
    @PostMapping(path = "/returnToStore")
    public String returnToStore(String returnPage) {
        return "redirect:" + returnPage;
    }
}
