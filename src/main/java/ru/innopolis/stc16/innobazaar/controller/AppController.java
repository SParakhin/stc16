package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc16.innobazaar.entity.Address;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    /**
     * Метод отображения формы регистрации пользователя
     * @param model
     * @return
     */
    @GetMapping("/addUserForm")
    public String showFormRegistrationUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    /**
     * Метод сохранения нового пользователя в БД
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.saveUser(user);
        return "welcome";
    }

    /**
     * Метод для отображения формы для изменения или удаления профиля пользователя
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateUserForm")
    public String showFormUpdateUser(@Valid @RequestParam("id") @PathVariable Long id, Model model) {
        User user = userService.getUser(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "editUser";
        }
        return "welcome";
    }

    /**
     * Метод для изменения профиля пользователя
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        userService.updateUser(user);
        return "redirect:/listUsers";
    }

    /**
     * Метод для удаления профиля пользователя
     * @param id
     * @return
     */
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") @PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/listUsers";
    }

    /**
     * Метод для отображения формы добавления адреса доставки для пользователя
     * @param id
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/addAddressForm")
    public String showFormAddAddress(@Valid @RequestParam("id") Long id,
                                     Model model,
                                     HttpSession session) {
        User user = userService.getUser(id);
        if (user != null) {
            session.setAttribute("id", id);
            Address address = new Address();
            model.addAttribute("address", address);
            model.addAttribute("user", user);
            return "addAddress";
        }
        return "redirect:/listUsers";
    }

    /**
     * Метод сохранения адреса доставки пользователя
     * @param session
     * @param address
     * @param bindingResult
     * @return
     */
    @PostMapping("/saveAddressToUser")
    public String saveAddressToUser(HttpSession session,
                                    Address address,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        }
        Object userId = session.getAttribute("id");
        User user = userService.getUser((Long) userId);
        user.addAddressToUser(address);
        userService.updateUser(user);
        return "redirect:/listUsers";
    }

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "listUsers";
    }
}