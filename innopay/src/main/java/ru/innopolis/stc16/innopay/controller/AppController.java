package ru.innopolis.stc16.innopay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innopay.service.StoreRegistrationService;

@Controller
@RequestMapping("/")
public class AppController {

    private final StoreRegistrationService storeRegistrationService;

    @Autowired
    public AppController(StoreRegistrationService storeRegistrationService) {
        this.storeRegistrationService = storeRegistrationService;
    }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PutMapping("/registerStore")
    public void registerStore(@RequestParam("storeName") String storeName) {
        storeRegistrationService.registerStore(storeName);
    }
}
