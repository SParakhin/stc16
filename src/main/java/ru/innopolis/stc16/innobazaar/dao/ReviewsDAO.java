package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.Reviews;

import java.util.List;

/**
 * DAO "Отзывы"
 */
public interface ReviewsDAO {

    List<Reviews> getAllReviews();

    void saveReviews(Reviews reviews);

    void deleteReviews(Long id);

    void updateReviews(Reviews reviews);

    Reviews getReviews(Long id);
}
