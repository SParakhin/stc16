package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.dto.Payment;
import ru.innopolis.stc16.innobazaar.entity.Booking;
import ru.innopolis.stc16.innobazaar.service.BookingService;

import java.text.SimpleDateFormat;

@Controller
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings/{id}")
    public String getBooking(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBooking(id);
        model.addAttribute("booking", booking);
        return "booking";
    }

    @GetMapping("/bookings/{id}/paidStatus")
    public String refreshPaymentStatus(@PathVariable Long id, @RequestParam("returnPage") String returnPage, Model model) {
        bookingService.refreshPaymentStatus(id);
        return getPaymentDetails(id, returnPage, model);
    }

    @GetMapping("/bookings/{id}/details")
    public String getPaymentDetails(@PathVariable Long id, @RequestParam("returnPage") String returnPage, Model model) {
        Payment payment = bookingService.getPayment(id);
        model.addAttribute("payment", payment);
        if (payment != null) {
            model.addAttribute("date", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(payment.getDate()));
        }
        model.addAttribute("returnPage", returnPage);
        return "paymentDetails";
    }

}
