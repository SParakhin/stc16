package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.BookingStatusDAO;
import ru.innopolis.stc16.innobazaar.entity.BookingStatus;

import java.util.List;
/**
 * Реализация Service сущности "Статус заказа"
 */
@Service
public class BookingStatusServiceImpl implements BookingStatusService{

    @Autowired
    BookingStatusDAO bookingStatusDAO;

    @Override
    public List<BookingStatus> getAllBookingStatus() {
        return bookingStatusDAO.getAllBookingStatus();
    }

    @Override
    public BookingStatus saveBookingStatus(BookingStatus bookingStatus) {
        return bookingStatusDAO.saveBookingStatus(bookingStatus);
    }

    @Override
    public BookingStatus getBookingStatus(Long id) {
        return bookingStatusDAO.getBookingStatus(id);
    }

    @Override
    public void deleteBookingStatus(Long id) {
        bookingStatusDAO.deleteBookingStatus(id);
    }

    @Override
    public void updateBookingStatus(BookingStatus bookingStatus) {
        bookingStatusDAO.updateBookingStatus(bookingStatus);
    }
}