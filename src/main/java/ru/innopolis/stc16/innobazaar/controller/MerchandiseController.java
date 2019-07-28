package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.entity.Store;
import ru.innopolis.stc16.innobazaar.service.StoreService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class MerchandiseController {

    private final StoreService storeService;

    private final HttpSession session;

    public MerchandiseController(StoreService storeService, HttpSession session) {
        this.storeService = storeService;
        this.session = session;
    }

    @GetMapping("/product/addProductForm")
    public String showFormAddProduct(Model model) {
        Merchandise merchandise = new Merchandise();
        Long storeId = (Long) session.getAttribute("storeId");
        model.addAttribute("merchandise", merchandise);
        model.addAttribute("storeId", storeId);
        return "merchandiseForm";
    }

    @PostMapping("product/saveProduct")
    public String saveProductToStore(@Valid Merchandise merchandise,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "merchandiseForm";
        }
        Object storeId = session.getAttribute("storeId");
        Store store = storeService.getStore((Long) storeId);
        store.addMerchandiseToStore(merchandise);
        storeService.updateStore(store);
        return "redirect:/store";
    }
}