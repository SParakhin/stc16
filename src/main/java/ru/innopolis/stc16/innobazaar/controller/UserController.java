package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
     * @param model
     * @return
     */

    @GetMapping("/user/updateUserForm")
    public String showFormUpdateUser(Model model,
                                     HttpSession session,
                                     Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        if (user != null) {
            model.addAttribute("user", user);
            session.setAttribute("userId", user.getId());
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
                             Principal principal,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "userForm";
        }
        user.setUsername(principal.getName());
        userService.updateUser(user);
        return "redirect:/user";
    }


    /**
     * Метод для удаления профиля пользователя
     *
     * @param session
     * @return
     */
    @GetMapping("/user/deleteUser")
    public String deleteUser(HttpSession session) {
        Object userId = session.getAttribute("id");
        userService.deleteUser((Long) userId);
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
    public String showUserPage(Model model,
                               HttpSession session) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userAuth", user);
        session.setAttribute("username", user.getUsername());
        Long userId = user.getId();
        session.setAttribute("id", userId);
        session.setAttribute("user", user);
        return "user";
    }
}