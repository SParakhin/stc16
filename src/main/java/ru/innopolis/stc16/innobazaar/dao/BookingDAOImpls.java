package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.Booking;
import ru.innopolis.stc16.innobazaar.entity.Store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Реализация DAO "Заказ"
 */
@Repository
@Transactional
public class BookingDAOImpls implements BookingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Booking> getAllBooking() {
        return entityManager.createNativeQuery("select * from booking", Booking.class).getResultList();
    }

    @Override
    public Booking saveBooking(Booking booking) {
        entityManager.persist(booking);
        entityManager.flush();
        return booking;
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = entityManager.find(Booking.class, id);
        entityManager.remove(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
        entityManager.merge(booking);
    }

    @Override
    public Booking getBooking(Long id) {
        return entityManager.find(Booking.class, id);
    }

}

