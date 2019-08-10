package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc16.innobazaar.entity.Category;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.service.CategoryService;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cat")
public class CategoryController {

    /**
     * Количество отображаемых на странице товаров
     */
    private static int GOODS_ON_PAGE = 9;

    @Autowired
    private MerchandiseService merchandiseService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String addForm(Model theModel) {

        Category category = new Category();
        category.setParentCategory(new Category());
        theModel.addAttribute("cat", category);

        return "categoryForm";
    }

    @GetMapping("/edit")
    public String editForm(@RequestParam("catName") String catName, Model theModel) {

        Category category = categoryService.findCategoryByName(catName);
        theModel.addAttribute("cat", category);
        theModel.addAttribute("isEdit", "true");

        return "categoryForm";
    }

    @PostMapping("/save")
    public String saveCategory(@Valid @ModelAttribute("cat") Category category, @RequestParam("isEdit") String isEdit, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "categoryForm";
        }

        if ("true".equalsIgnoreCase(isEdit)) {
            categoryService.updateCategory(category);
        } else {
            categoryService.saveCategory(category);
        }

        return "categoryList";
    }

    @GetMapping("/list")
    public String listCats(Model theModel) {

        Map<String, String> catsContainer = new TreeMap<>();
        List<Category> catsList = (categoryService != null) ? categoryService.getAllCategories() : null;

        if (catsList == null || catsList.isEmpty()) {
            catsContainer.put("категорий нет", "#");
        } else {
            for (Category cat : catsList) {
                catsContainer.put(cat.getName(), cat.getName());
            }
        }

        theModel.addAttribute("cats", catsContainer);

        return "categoryList";
    }

    @GetMapping("/openWithGoods")
    public String showCategoryWithGoods(
            @RequestParam("catName") String theName,
            @RequestParam("pageNumber") int pageNumber,
            Model theModel
    ) {
        List<Merchandise> goodsList = merchandiseService.getMerchandiseByCategory(theName);

        int listLength = goodsList.size();
        int numberOfPages = (listLength % GOODS_ON_PAGE == 0)
                ? listLength / GOODS_ON_PAGE
                : listLength / GOODS_ON_PAGE + 1;

        List<Integer> pageNumbers = new ArrayList<>();
        for (int i = 0; i < numberOfPages; i++) {
            pageNumbers.add(i + 1);
        }

        List<Merchandise> goodsListToSend;
        if (numberOfPages > 1) {
            goodsListToSend = goodsList.stream()
                    .skip(GOODS_ON_PAGE * (pageNumber - 1))
                    .limit(GOODS_ON_PAGE)
                    .collect(Collectors.toList());
        } else {
            goodsListToSend = goodsList;
        }

        theModel.addAttribute("catName", theName);
        theModel.addAttribute("goods", goodsListToSend);
        theModel.addAttribute("currentPageNumber", pageNumber);
        theModel.addAttribute("pageNumbers", pageNumbers);

        return "categoryWithGoods";
    }

}

