package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.Reviews;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Реализация DAO "Отзывы"
 */
@Repository
@Transactional
public class ReviewsDAOImpls implements ReviewsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Reviews> getAllReviews() {
        return entityManager.createNativeQuery("select * from reviews", Reviews.class).getResultList();
    }

    @Override
    public void saveReviews(Reviews reviews) {
        entityManager.persist(reviews);
    }

    @Override
    public void deleteReviews(Long id) {
        Reviews reviews = entityManager.find(Reviews.class, id);
        entityManager.remove(reviews);
    }

    @Override
    public void updateReviews(Reviews reviews) {
        entityManager.merge(reviews);
    }

    @Override
    public Reviews getReviews(Long id) {
        return entityManager.find(Reviews.class, id);
    }
}

