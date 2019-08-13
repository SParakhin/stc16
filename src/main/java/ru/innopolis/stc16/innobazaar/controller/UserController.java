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
import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    private final HttpSession session;

    public UserController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
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
        return "redirect:/login";
    }

    /**
     * Метод для отображения формы для изменения или удаления профиля пользователя
     *
     * @param model
     * @return
     */

    @GetMapping("/user/updateUserForm")
    public String showFormUpdateUser(Model model) {
        User user = userService.getAuthenticatedUser();
        if (user != null) {
            model.addAttribute("user", user);
            return "userForm";
        }
        return "redirect:/addUserForm";
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
                             Principal principal,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        user.setUsername(principal.getName());
        User newUser = userService.updateUserProfile(user);
        session.setAttribute("userId",newUser.getId());
        return "redirect:/user/updateUserForm";
    }

    /**
     * Метод для удаления профиля пользователя
     *
     * @return
     */
    @GetMapping("/user/deleteUser")
    public String deleteUser() {
        User user = userService.getAuthenticatedUser();
        userService.deleteUser(user.getId());
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/user/deleteUserFromList")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/listUsers";
    }

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "listUsers";
    }

    @GetMapping("/user")
    public String showUserPage(Model model) {
        User user = userService.getAuthenticatedUser();
        model.addAttribute("userAuth", user);
        model.addAttribute("user", user);
        return "user";
    }
}