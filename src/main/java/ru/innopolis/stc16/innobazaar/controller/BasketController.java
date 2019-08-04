package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Basket;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.service.BasketService;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class BasketController {
    private final BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }


    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String getBasket(Model model, @RequestParam(required = false, name = "basketID") String basketID) {
        Basket basket = basketService.getBasket(Long.valueOf(basketID));
        List<Merchandise> merchandises = basket.getMerchandise();
        BigDecimal totalSum = merchandises.stream().map(merchandise -> merchandise.getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("merchandises", merchandises);
        model.addAttribute("totalSum", totalSum);
        return "basket";
    }

}
