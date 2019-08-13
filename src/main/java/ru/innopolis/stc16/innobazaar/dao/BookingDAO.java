package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.Booking;

import java.util.List;

/**
 * DAO "Заказ"
 */
public interface BookingDAO {

    List<Booking> getAllBooking();

    Booking saveBooking(Booking booking);

    void deleteBooking(Long id);

    void updateBooking(Booking booking);

    Booking getBooking(Long id);
}
