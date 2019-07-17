package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.BookingDAO;
import ru.innopolis.stc16.innobazaar.entity.Booking;

import java.util.List;

/**
 * Реализация Service сущности "Заказ"
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingDAO bookingDAO;

    @Override
    public List<Booking> getAllBooking() {
        return bookingDAO.getAllBooking();
    }

    @Override
    public void saveBooking(Booking booking) {
        bookingDAO.saveBooking(booking);
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
}
