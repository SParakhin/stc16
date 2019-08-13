package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.entity.MerchandisePage;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.CategoryService;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    private MerchandiseService merchandiseService;
    private CategoryService categoryService;
    private UserService userService;

    AppController(MerchandiseService merchandiseService, CategoryService categoryService, UserService userService) {
        this.merchandiseService = merchandiseService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String showMain(Model model, HttpSession session) {
        model.addAttribute("categories", categoryService.getAllCategories());
        User user = userService.getAuthenticatedUser();
        if (user != null) {
            List<Merchandise> basket = user.getMerchandises();
            session.setAttribute("basketSize", basket.size());
        }
        return "app-main";
    }

    @PostMapping("/search")
    public String search(ProductsSearchCriteria criteria, Model model) {
        MerchandisePage merchandises = merchandiseService.getBySearchCriteria(criteria);
        model.addAttribute("merchandisesPage", merchandises);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("criteria", criteria);
        return "search";
    }
}