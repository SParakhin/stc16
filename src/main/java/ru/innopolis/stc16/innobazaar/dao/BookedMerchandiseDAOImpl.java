package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.BookedMerchandise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class BookedMerchandiseDAOImpl implements BookedMerchandiseDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BookedMerchandise saveBookedMerchandise(BookedMerchandise bookedMerchandise) {
        entityManager.persist(bookedMerchandise);
        entityManager.flush();
        return bookedMerchandise;
    }
}
