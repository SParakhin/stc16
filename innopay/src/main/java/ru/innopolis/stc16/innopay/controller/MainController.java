package ru.innopolis.stc16.innopay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

}
