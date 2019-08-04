package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.service.CategoryService;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CategoryController {

    @Autowired
    private MerchandiseService merchandiseService;

    @GetMapping("/openWithGoods")
    public String showCategoryWithGoods(@RequestParam("catName") String theName, Model theModel) {

        List<Merchandise> goodsList = merchandiseService.getMerchandiseByCategory(theName);

        theModel.addAttribute("goods", goodsList);

        return "categoryWithGoods";
    }

}

