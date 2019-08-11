package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc16.innobazaar.config.PayServiceIntegrator;
import ru.innopolis.stc16.innobazaar.entity.Booking;
import ru.innopolis.stc16.innobazaar.service.BookingService;

import java.math.BigDecimal;

@Controller
@RequestMapping("/")
public class DemoPaymentController {

    private final BookingService bookingService;
    private final PayServiceIntegrator payServiceIntegrator;

    @Autowired
    public DemoPaymentController(BookingService bookingService, PayServiceIntegrator payServiceIntegrator) {
        this.bookingService = bookingService;
        this.payServiceIntegrator = payServiceIntegrator;
    }

    @GetMapping(path = "/demoPayment")
    public String testPayment(Model model) {
        Booking booking = bookingService.getBooking(1L);
        model.addAttribute("store", payServiceIntegrator.getStore());
        model.addAttribute("booking", booking);
        model.addAttribute("amount", booking.getMerchandise().getPrice().multiply(BigDecimal.valueOf(booking.getCount())));
        return "demoPayment";
    }
}
