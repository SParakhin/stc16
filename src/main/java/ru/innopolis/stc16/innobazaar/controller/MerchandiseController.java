package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.service.BasketService;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class MerchandiseController {

    private final MerchandiseService merchandiseService;
    private final UserService userService;
    private final BasketService basketService;

    @Autowired
    public MerchandiseController(MerchandiseService merchandiseService, UserService userService, BasketService basketService) {
        this.merchandiseService = merchandiseService;
        this.userService = userService;
        this.basketService = basketService;
    }

    @RequestMapping(value = "/merchandise", method = RequestMethod.GET)
    public String getMerchandise(Model model, @RequestParam(required = false, name = "merchandiseId") String merchandiseId){
        model.addAttribute("merchandiseObject", merchandiseService.getMerchandise(Long.valueOf(merchandiseId)));
        return "merchandise";
    }

    @RequestMapping(value = "/merchandise/add", method = RequestMethod.POST)
    public String addMerchandiseToBasket(Model model, @RequestParam(name = "merchandiseId") String merchandiseId,
                                         HttpSession session) {
        Merchandise merchandise = merchandiseService.getMerchandise(Long.valueOf(merchandiseId));
        Long userId = (Long) session.getAttribute("id");
        basketService.addMerchandise(userService.getUser(userId).getBasket().getId(), merchandise);
        return "basket";
    }
}
