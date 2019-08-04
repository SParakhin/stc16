package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.service.ReviewsService;

@Controller
public class ReviewsController {

    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public String getReviews(Model model, @RequestParam(required = false, name = "reviewsId") String reviewsId){
        model.addAttribute("reviewsObject", reviewsService.getReviews(Long.valueOf(reviewsId)));
        return "reviews";
    }
}
