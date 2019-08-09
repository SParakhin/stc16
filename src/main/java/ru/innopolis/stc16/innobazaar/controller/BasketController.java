package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Basket;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.entity.Store;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.BasketService;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;
import ru.innopolis.stc16.innobazaar.service.StoreService;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class BasketController {
    private final BasketService basketService;
    private final HttpSession session;
    private final MerchandiseService merchandiseService;
    private final UserService userService;
    private final StoreService storeService;

    @Autowired
    public BasketController(BasketService basketService, HttpSession session, MerchandiseService merchandiseService, UserService userService, StoreService storeService) {
        this.basketService = basketService;
        this.session = session;
        this.merchandiseService = merchandiseService;
        this.userService = userService;
        this.storeService = storeService;
    }

    /**
     * Метод добавления товара в корзину с хранением в БД
     *
     * @param id
     * @return
     */

    @GetMapping("/addBasket")
    public String addBasket(@RequestParam Long id) {
        User user = userService.getAuthenticatedUser();
        Basket userBasket = user.getBasket();
        if (userBasket == null) {
            userBasket = getNewBasket(user);
        }
        Merchandise merchandise = merchandiseService.getMerchandise(id);
        userBasket.getMerchandises().add(merchandise);
        merchandise.getBasketList().add(userBasket);
        user.setBasket(userBasket);
        userService.updateUserRelation(user);
        List<Merchandise> basket = userBasket.getMerchandises();
        session.setAttribute("basket", basket);
        BigDecimal totalSum = BigDecimal.ZERO;
        for (Merchandise m : basket) {
            totalSum = totalSum.add(m.getPrice());
        }
        session.setAttribute("totalSum", totalSum);
        session.setAttribute("basketSize", basket.size());
        return "redirect:/basket";
    }

    /**
     * Метод создания корзины при прямом обращении к корзине после авторизации пользователя
     *
     * @param user
     * @return
     */
    private Basket getNewBasket(User user) {
        Basket userBasket = new Basket();
        userBasket.setUser(user);
        basketService.saveBasket(userBasket);
        user.setBasket(userBasket);
        userService.updateUser(user);
        return userBasket;
    }

    /**
     * Страница корзины
     */
    @GetMapping("/basket")
    public String showBasket(Model model) {
        User user = userService.getAuthenticatedUser();
        Basket userBasket = user.getBasket();
        List<Merchandise> basket;
        if (userBasket == null) {
            basket = getNewBasket(user).getMerchandises();
        } else {
            basket = userBasket.getMerchandises();
            model.addAttribute("basketSize", basket.size());
            session.setAttribute("basketSize", basket.size());
        }
        BigDecimal totalSum = (BigDecimal) session.getAttribute("totalSum");
        model.addAttribute("totalSum", totalSum);
        Set<Store> storeListBasket = new HashSet<>();
        Map<Store, List<Merchandise>> basketStoreMap = new HashMap<>();
        for (Merchandise s : userBasket.getMerchandises()) {
            storeListBasket.add(s.getStore());
            basketStoreMap.put(s.getStore(), new ArrayList<>());
        }
        for (Map.Entry<Store, List<Merchandise>> item : basketStoreMap.entrySet()) {
            for (Store s : storeListBasket) {
                if (item.getKey().equals(s)) {
                    for (Merchandise m : basket) {
                        if (m.getStore().getId().equals(item.getKey().getId())) {
                            item.getValue().add(m);
                            basketStoreMap.put(s, item.getValue());
                        }
                    }
                }
            }
        }
        model.addAttribute("basketStoreMap", basketStoreMap);
        session.setAttribute("basketStoreMap", basketStoreMap);
        session.setAttribute("basket", basket);
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
        User user = userService.getAuthenticatedUser();
        BigDecimal totalSum = (BigDecimal) session.getAttribute("totalSum");
        Basket userBasket = user.getBasket();
        List<Merchandise> basket = userBasket.getMerchandises();
        BigDecimal newTotalSum = BigDecimal.ZERO;
        for (Merchandise m : basket) {
            if ((m.getId().equals(id))) {
                basket.remove(m);
                newTotalSum = totalSum.subtract(m.getPrice());
                break;
            }
        }
        session.removeAttribute("totalSum");
        session.removeAttribute("basketSize");
        session.removeAttribute("basket");
        userBasket.setMerchandises(basket);
        user.setBasket(userBasket);
        userService.updateUserRelation(user);
        session.setAttribute("totalSum", newTotalSum);
        session.setAttribute("basketSize", basket.size());
        session.setAttribute("basket", basket);
        return "redirect:/basket";
    }
}