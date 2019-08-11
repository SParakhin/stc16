package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.BookingStatus;

import java.util.List;

/**
 * DAO "Товар"
 */
public interface BookingStatusDAO {

    List<BookingStatus> getAllBookingStatus();

    BookingStatus saveBookingStatus(BookingStatus bookingStatus);

    void deleteBookingStatus(Long id);

    void updateBookingStatus(BookingStatus bookingStatus);

    BookingStatus getBookingStatus(Long id);
}
