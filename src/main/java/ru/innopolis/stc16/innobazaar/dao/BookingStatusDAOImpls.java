package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.BookingStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Реализация DAO "Статус заказа"
 */
@Repository
@Transactional
public class BookingStatusDAOImpls implements BookingStatusDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BookingStatus> getAllBookingStatus() {
        return entityManager.createNativeQuery("select * from booking_status", BookingStatus.class).getResultList();
    }

    @Override
    public void saveBookingStatus(BookingStatus bookingStatus) {
        entityManager.persist(bookingStatus);
    }

    @Override
    public void deleteBookingStatus(Long id) {
        BookingStatus bookingStatus = entityManager.find(BookingStatus.class, id);
        entityManager.remove(bookingStatus);
    }

    @Override
    public void updateBookingStatus(BookingStatus bookingStatus) {
        entityManager.merge(bookingStatus);
    }

    @Override
    public BookingStatus getBookingStatus(Long id) {
        return entityManager.find(BookingStatus.class, id);
    }
}


