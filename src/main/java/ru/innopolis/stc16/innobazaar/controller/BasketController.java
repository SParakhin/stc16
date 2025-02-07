package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.entity.Store;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class BasketController {
    private final HttpSession session;
    private final MerchandiseService merchandiseService;
    private final UserService userService;

    @Autowired
    public BasketController(HttpSession session, MerchandiseService merchandiseService, UserService userService) {
        this.session = session;
        this.merchandiseService = merchandiseService;
        this.userService = userService;
    }

    /**
     * Метод добавления товара в корзину с хранением в БД
     *
     * @param id
     * @return
     */

    @GetMapping("/addBasket")
    public String addBasket(@RequestParam Long id,
                            HttpServletResponse response,
                            HttpServletRequest request) throws IOException, ServletException {
        User user = userService.getAuthenticatedUser();
        if (user != null) {
            Merchandise merchandise = merchandiseService.getMerchandise(id);
            List<Merchandise> basket = user.getMerchandises();
            basket.add(merchandise);
            userService.updateUserLinks(user);
            BigDecimal totalSum = BigDecimal.ZERO;
            for (Merchandise m : basket) {
                totalSum = totalSum.add(m.getPrice());
            }
            session.setAttribute("totalSum", totalSum);
            session.setAttribute("basketSize", basket.size());
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }
        return "redirect:/basket";
    }

    /**
     * Страница корзины
     */
    @GetMapping("/basket")
    public String showBasket(Model model,
                             HttpServletResponse response,
                             HttpServletRequest request) throws IOException, ServletException {
        User user = userService.getAuthenticatedUser();
        if (user == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        } else {
            List<Merchandise> basket = user.getMerchandises();
            model.addAttribute("basketSize", basket.size());
            session.setAttribute("basketSize", basket.size());
            BigDecimal totalSum = (BigDecimal) session.getAttribute("totalSum");
            model.addAttribute("totalSum", totalSum);
            Set<Store> storeListBasket = new HashSet<>();
            Map<Store, List<Merchandise>> basketStoreMap = new HashMap<>();
            for (Merchandise s : basket) {
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
        }
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
        List<Merchandise> basket = user.getMerchandises();
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
        user.setMerchandises(basket);
        userService.updateUserLinks(user);
        session.setAttribute("totalSum", newTotalSum);
        session.setAttribute("basketSize", basket.size());
        session.setAttribute("basket", basket);
        return "redirect:/basket";
    }
}