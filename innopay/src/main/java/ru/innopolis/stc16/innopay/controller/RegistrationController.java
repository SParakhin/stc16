package ru.innopolis.stc16.innopay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innopay.entity.Store;
import ru.innopolis.stc16.innopay.service.StoreService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final StoreService storeRegistrationService;

    @Autowired
    public RegistrationController(StoreService storeRegistrationService) {
        this.storeRegistrationService = storeRegistrationService;
    }

    @GetMapping("/registerStore")
    public String registerStore(@RequestParam("storeName") String storeName, Model model) {
        if (storeRegistrationService.isStoreExists(storeName)) {
            return "alreadyRegisteredStore";
        }
        Store newStore = storeRegistrationService.registerStore(storeName);
        if (newStore == null) {
            return "errorRegisterStore";
        }
        model.addAttribute("store", newStore);
        return "successRegisterStore";
    }
}
