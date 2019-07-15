package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод отображения формы регистрации пользователя
     *
     * @param model
     * @return
     */
    @GetMapping("/addUserForm")
    public String showFormRegistrationUser(Model model,
                                           HttpServletRequest request) {
        User user = new User();
        request.setAttribute("newUser", user);
        model.addAttribute("user", user);
        return "userForm";
    }

    /**
     * Метод сохранения нового пользователя в БД
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/saveUser")
    public String saveUser(@Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        userService.saveUser(user);
        return "redirect:/listUsers";
    }

    /**
     * Метод для отображения формы для изменения или удаления профиля пользователя
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/updateUserForm")
    public String showFormUpdateUser(@RequestParam("id") Long id,
                                     Model model,
                                     HttpSession session) {
        session.setAttribute("id", id);
        User user = userService.getUser(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "userForm";
        }
        return "redirect:/listUsers";
    }

    /**
     * Метод для изменения профиля пользователя
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @PostMapping("/user/updateUser")
    public String updateUser(@Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        userService.updateUser(user);
        return "redirect:/listUsers";
    }

    /**
     * Метод для удаления профиля пользователя
     *
     * @param id
     * @return
     */
    @GetMapping("/user/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/listUsers";
    }

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "listUsers";
    }
}