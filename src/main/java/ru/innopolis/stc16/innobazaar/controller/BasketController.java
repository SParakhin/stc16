package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Basket;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.BasketService;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BasketController {
    private final BasketService basketService;
    private final HttpSession session;
    private final MerchandiseService merchandiseService;
    private final UserService userService;

    @Autowired
    public BasketController(BasketService basketService, HttpSession session, MerchandiseService merchandiseService, UserService userService) {
        this.basketService = basketService;
        this.session = session;
        this.merchandiseService = merchandiseService;
        this.userService = userService;
    }

    /**
     * Метод добавления товара в корзину. Сохранение корзины в сессии
     *
     * @param id
     * @return
     */
//    @GetMapping("/addBasket")
//    public String addBasket(@RequestParam Long id) {
//        List<Merchandise> basket = (List<Merchandise>) session.getAttribute("basket");
//        Merchandise merchandise = merchandiseService.getMerchandise(id);
//        if (basket == null) {
//            basket = new ArrayList<>();
//            basket.add(merchandise);
//        } else {
//            basket.add(merchandise);
//        }
//        session.setAttribute("basket", basket);
//        BigDecimal totalSum = BigDecimal.ZERO;
//        if (!basket.isEmpty()) {
//            for (Merchandise m : basket) {
//                totalSum = totalSum.add(m.getPrice());
//            }
//            session.setAttribute("totalSum", totalSum);
//            session.setAttribute("basketSize", basket.size());
//        }
//        return "redirect:/basket";
//    }

    /**
     * Метод добавления товара в корзину с хранением в БД
     *
     * @param id
     * @return
     */

    @GetMapping("/addBasket")
    public String addBasket(@RequestParam Long id) {
        User user = userService.getAuthenticatedUser();
//        Basket userBasket = user.getBasket();
//        if (userBasket == null) {
//            userBasket = new Basket();
//            userBasket.setUser(user);
////            user.setBasket(userBasket);
//        } else {
//            userBasket = user.getBasket();
//        }

        Basket userBasket = new Basket();
        Merchandise merchandise = merchandiseService.getMerchandise(id);
        userBasket.addMerchandiseToBasket(merchandise);
        List<Merchandise> basket = userBasket.getMerchandises();
//        user.setBasket(userBasket);
//        userService.updateUser(user);
//        userBasket.setUser(user);
        user.setBasket(userBasket);
        userService.updateUserRelation(user);
//        basketService.saveBasket(userBasket);
        session.setAttribute("basket", basket);
        BigDecimal totalSum = BigDecimal.ZERO;
        for (Merchandise m : basket) {
            totalSum = totalSum.add(m.getPrice());
        }
        session.setAttribute("totalSum", totalSum);
        session.setAttribute("basketSize", basket.size());
//        basketService.saveBasket(userBasket);
//        return "redirect:/basket";
        return "redirect:/";
    }

    /**
     * Страница корзины
     */
    @GetMapping("/basket")
    public String showBasket(Model model) {
        List<Merchandise> basket = (List<Merchandise>) session.getAttribute("basket");
        BigDecimal totalSum = (BigDecimal) session.getAttribute("totalSum");
        model.addAttribute("basket", basket);
        model.addAttribute("totalSum", totalSum);
        return "basket";
    }

    /**
     * Метод удаления товара из корзинв
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteFromBasket")
    public String deleteProductFromBasket(@RequestParam Long id) {
        List<Merchandise> basket = (List<Merchandise>) session.getAttribute("basket");
        List<Merchandise> tempBasket = new ArrayList<>();
        BigDecimal newTotalSum = BigDecimal.ZERO;
        for (Merchandise m : basket) {
            if (!(m.getId().equals(id))) {
                tempBasket.add(m);
                newTotalSum = newTotalSum.add(m.getPrice());
            }
        }
        session.removeAttribute("totalSum");
        session.removeAttribute("basketSize");
        session.removeAttribute("basket");
        session.setAttribute("totalSum", newTotalSum);
        session.setAttribute("basketSize", tempBasket.size());
        session.setAttribute("basket", tempBasket);
        return "redirect:/basket";
    }
}
