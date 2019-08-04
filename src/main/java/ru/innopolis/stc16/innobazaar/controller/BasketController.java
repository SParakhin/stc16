package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.service.BasketService;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BasketController {
    private final BasketService basketService;
    private final HttpSession session;
    private final MerchandiseService merchandiseService;

    @Autowired
    public BasketController(BasketService basketService, HttpSession session, MerchandiseService merchandiseService) {
        this.basketService = basketService;
        this.session = session;
        this.merchandiseService = merchandiseService;
    }


//    @RequestMapping(value = "/basket", method = RequestMethod.GET)
//    public String getBasket(Model model, @RequestParam(required = false, name = "basketID") String basketID) {
//        Basket basket = basketService.getBasket(Long.valueOf(basketID));
//        List<Merchandise> merchandises = basket.getMerchandise();
//        BigDecimal totalSum = merchandises.stream().map(merchandise -> merchandise.getPrice())
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
//        model.addAttribute("merchandises", merchandises);
//        model.addAttribute("totalSum", totalSum);
//        return "basket";
//    }

    /**
     * Метод добавления товара в корзину. Сохранение корзины в сессии
     *
     * @param id
     * @return
     */
    @GetMapping("/addBasket")
    public String addBasket(@RequestParam Long id) {
        List<Merchandise> basket = (List<Merchandise>) session.getAttribute("basket");
        Merchandise merchandise = merchandiseService.getMerchandise(id);
        if (basket == null) {
            basket = new ArrayList<>();
        } else {
            basket.add(merchandise);
        }
        BigDecimal totalSum = BigDecimal.ZERO;
        if (!basket.isEmpty()) {
            for (Merchandise m : basket) {
                totalSum.add(m.getPrice());
            }
        }
        session.setAttribute("basket", basket);
        session.setAttribute("totalSum", totalSum);
        return "redirect:/store/listStore";
    }

    /**
     * Страница корзины
     */
    @GetMapping("/basket")
    public String showBasket(Model model) {
        //TODO Если корзина пустая, добавить атрибут запроса newBasket и в jsp вывод сообщения
        List<Merchandise> basket = (List<Merchandise>) session.getAttribute("basket");
        BigDecimal totalSum = (BigDecimal) session.getAttribute("totalSum");
        model.addAttribute("basket", basket);
        model.addAttribute("totalSum", totalSum);
        return "basket";
    }


}
