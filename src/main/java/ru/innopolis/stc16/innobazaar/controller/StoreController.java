package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc16.innobazaar.service.UserService;

@Controller
@RequestMapping("/store")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/main")
    public String index() {
        return "storeMain";
    }
}
