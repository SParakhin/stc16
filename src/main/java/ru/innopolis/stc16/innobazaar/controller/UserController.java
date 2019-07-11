//package ru.innopolis.stc16.innobazaar.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ru.innopolis.stc16.innobazaar.service.UserService;
//
//
//@Controller
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login(Model model) {
//        return "login";
//    }
//
//    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
//    public String welcome(Model model) {
//        return "welcome";
//    }
//
//}
