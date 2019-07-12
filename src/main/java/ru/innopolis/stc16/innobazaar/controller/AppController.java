package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping("/")
    public String showMain() {

        return "app-main";
    }
}