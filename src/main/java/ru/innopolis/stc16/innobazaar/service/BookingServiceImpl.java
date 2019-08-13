package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.innopolis.stc16.innobazaar.config.PayServiceIntegrator;
import ru.innopolis.stc16.innobazaar.dao.BookingDAO;
import ru.innopolis.stc16.innobazaar.dto.Payment;
import ru.innopolis.stc16.innobazaar.dto.Store;
import ru.innopolis.stc16.innobazaar.entity.BookedMerchandise;
import ru.innopolis.stc16.innobazaar.entity.Booking;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Реализация Service сущности "Заказ"
 */
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingDAO bookingDAO;
    private final PayServiceIntegrator payServiceIntegrator;

    @Autowired
    public BookingServiceImpl(BookingDAO bookingDAO, PayServiceIntegrator payServiceIntegrator) {
        this.bookingDAO = bookingDAO;
        this.payServiceIntegrator = payServiceIntegrator;
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingDAO.getAllBooking();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingDAO.saveBooking(booking);
    }

    @Override
    public Booking getBooking(Long id) {
        return bookingDAO.getBooking(id);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingDAO.deleteBooking(id);
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDAO.updateBooking(booking);
    }

    @Override
    public Payment getPayment(Long id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<Store> request = new HttpEntity<>(payServiceIntegrator.getStore());
            return restTemplate.postForObject(payServiceIntegrator.getPayServiceURL() + "/payments/getPayment?id=" + id, request, Payment.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Payment refreshPaymentStatus(Long id) {
        Payment payment = null;
        Booking booking = getBooking(id);
        try {
            payment = getPayment(id);
            boolean isStoreEquals = payment.getStoreName().equals(payServiceIntegrator.getStore().getName());
            BigDecimal price = BigDecimal.ZERO;
            for (BookedMerchandise merchandise: booking.getMerchandise()) {
                price = price.add(merchandise.getMerchandise().getPrice().multiply(BigDecimal.valueOf(merchandise.getCount())));
            }
            boolean isAmountEquals = price.equals(Objects.requireNonNull(payment).getAmount());
            booking.setPaid(isStoreEquals && isAmountEquals);
            if (booking.getPaid()) {
                booking.setBookingStatus("Ожидается доставка");
            }
        } catch(Exception e) {
            booking.setPaid(false);
        }
        updateBooking(booking);
        return payment;
    }

}
