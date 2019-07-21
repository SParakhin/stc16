package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.service.MerchandiseService;

@Controller
public class MerchandiseController {

    private final MerchandiseService merchandiseService;

    @Autowired
    public MerchandiseController(MerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }

    @RequestMapping(value = "/merchandise", method = RequestMethod.GET)
    public String getMerchandise(Model model, @RequestParam(required = false, name = "merchandiseId") String merchandiseId){
        model.addAttribute("merchandiseObject", merchandiseService.getMerchandise(Long.valueOf(merchandiseId)));
        return "merchandise";
    }
}
