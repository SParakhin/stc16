package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc16.innobazaar.entity.Category;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.entity.Store;
import ru.innopolis.stc16.innobazaar.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MerchandiseController {

    private final MerchandiseService merchandiseService;
    private final StoreService storeService;
    private final HttpSession session;
    private final CategoryService categoryService;

    @Autowired
    public MerchandiseController(MerchandiseService merchandiseService, StoreService storeService, HttpSession session, CategoryService categoryService) {
        this.merchandiseService = merchandiseService;
        this.storeService = storeService;
        this.session = session;
        this.categoryService = categoryService;
    }

    /**
     * Карточка товара
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/merchandise", method = RequestMethod.GET)
    public String getMerchandise(Model model, @RequestParam Long id) {
        model.addAttribute("merchandiseObject", merchandiseService.getMerchandise(Long.valueOf(id)));
        return "merchandise";
    }

    /**
     * Форма добавления товара в магазин
     *
     * @param model
     * @return
     */
    @GetMapping("/product/addProductForm")
    public String showFormAddProduct(Model model,
                                     HttpServletRequest request) {
        Merchandise merchandise = new Merchandise();
        Long storeId = (Long) session.getAttribute("storeId");
        model.addAttribute("merchandise", merchandise);
        model.addAttribute("storeId", storeId);
        model.addAttribute("categories", categoryService.getAllCategories());
        request.setAttribute("newProduct", merchandise);
        return "merchandiseForm";
    }

    /**
     * Метод сохранения товара в магазин
     *
     * @param merchandise
     * @param bindingResult
     * @return
     */
    @PostMapping("/product/saveProduct")
    public String saveProductToStore(@Valid Merchandise merchandise,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "merchandiseForm";
        }
        Object storeId = session.getAttribute("storeId");
        Store store = storeService.getStore((Long) storeId);
        Category category = categoryService.findCategoryByName(merchandise.getCategoryName());
        merchandise.setCategory(category);
        store.addMerchandiseToStore(merchandise);
        storeService.updateStore(store);
        return "redirect:/store#products";
    }

    /**
     * Метод отображения формы для редактирования характеристик товара
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/product/updateProductForm")
    public String showFormUpdateProduct(@RequestParam("id") Long id,
                                        Model model) {
        Object storeId = session.getAttribute("storeId");
        Store store = storeService.getStore((Long) storeId);
        model.addAttribute("categories", categoryService.getAllCategories());
        List<Merchandise> merchandises = store.getMerchandiseList();
        for (Merchandise merchandise : merchandises) {
            if (merchandise.getId().equals(id)) {
                model.addAttribute("merchandise", merchandise);
                return "merchandiseForm";
            }
        }
        return "redirect:/store#products";
    }

    /**
     * Метод изменения характеристик товара
     *
     * @param merchandise
     * @param bindingResult
     * @return
     */
    @PostMapping("/product/updateProduct")
    public String updateProduct(@Valid Merchandise merchandise,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "merchandiseForm";
        }
        Object storeId = session.getAttribute("storeId");
        Store store = storeService.getStore((Long) storeId);
        if (merchandise.getId() == null) {
            return "merchandiseForm";
        }
        List<Merchandise> products = store.getMerchandiseList();
        for (Merchandise product : products) {
            if (product.getId().equals(merchandise.getId())) {
                product.setId(merchandise.getId());
                product.setName(merchandise.getName());
                product.setCategory(categoryService.findCategoryByName(merchandise.getCategoryName()));
                product.setCategoryName(merchandise.getCategoryName());
                product.setDescription(merchandise.getDescription());
                product.setPictureUrl(merchandise.getPictureUrl());
                product.setPrice(merchandise.getPrice());
            }
            store.setMerchandiseList(products);
            storeService.updateStore(store);
        }
        return "redirect:/store#products";
    }

    /**
     * Метод удаления товара из магазина
     *
     * @param id
     * @return
     */
    @GetMapping("/product/deleteProduct")
    public String deleteProductFromStore(@RequestParam Long id) {
        Object storeId = session.getAttribute("storeId");
        Store store = storeService.getStore((Long) storeId);
        List<Merchandise> products = store.getMerchandiseList();
        List<Merchandise> temp = new ArrayList<>();
        for (Merchandise m : products) {
            if (!m.getId().equals(id)) {
                temp.add(m);
            }
        }
        store.setMerchandiseList(temp);
        storeService.updateStore(store);
        return "redirect:/store#products";
    }
}