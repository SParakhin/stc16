package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.BookingStatus;

import java.util.List;

/**
 * Service сущности "Статус заказа"
 */
public interface BookingStatusService {

    List<BookingStatus> getAllBookingStatus();

    BookingStatus saveBookingStatus(BookingStatus bookingStatus);

    BookingStatus getBookingStatus(Long id);

    void deleteBookingStatus(Long id);

    void updateBookingStatus(BookingStatus bookingStatus);
}
