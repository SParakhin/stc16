package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.Booking;

import java.util.List;

/**
 * Service сущности "Заказ"
 */
public interface BookingService {

    List<Booking> getAllBooking();

    Booking saveBooking(Booking booking);

    Booking getBooking(Long id);

    void deleteBooking(Long id);

    void updateBooking(Booking booking);
}
