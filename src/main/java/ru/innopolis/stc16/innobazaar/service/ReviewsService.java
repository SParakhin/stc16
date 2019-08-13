package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.Reviews;

import java.util.List;

/**
 * Service сущности "Отзывы"
 */
public interface ReviewsService {

    List<Reviews> getAllReviews();

    void saveReviews(Reviews reviews);

    Reviews getReviews(Long id);

    void deleteReviews(Long id);

    void updateReviews(Reviews reviews);
}
