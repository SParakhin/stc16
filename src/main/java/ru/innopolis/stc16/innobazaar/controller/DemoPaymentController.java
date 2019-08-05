package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoPaymentController {

    @GetMapping(path = "/demoPayment")
    public String testPayment() {
        return "demoPayment";
    }
}
