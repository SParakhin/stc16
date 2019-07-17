package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.ReviewsDAO;
import ru.innopolis.stc16.innobazaar.entity.Reviews;

import java.util.List;

/**
 * Реализация Service сущности "Отзывы"
 */
@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    ReviewsDAO reviewsDAO;

    @Override
    public List<Reviews> getAllReviews() {
        return reviewsDAO.getAllReviews();
    }

    @Override
    public void saveReviews(Reviews reviews) {
        reviewsDAO.saveReviews(reviews);
    }

    @Override
    public Reviews getReviews(Long id) {
        return reviewsDAO.getReviews(id);
    }

    @Override
    public void deleteReviews(Long id) {
        reviewsDAO.deleteReviews(id);
    }

    @Override
    public void updateReviews(Reviews reviews) {
        reviewsDAO.updateReviews(reviews);
    }
}



