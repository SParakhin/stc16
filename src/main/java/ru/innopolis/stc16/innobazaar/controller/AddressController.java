package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Address;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class AddressController {

    private final UserService userService;

    public AddressController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод для отображения формы добавления адреса доставки для пользователя
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/address/addAddressForm")
    public String showFormAddAddress(Model model,
                                     HttpSession session,
                                     HttpServletRequest request) {
        session.getAttribute("id");
        Address address = new Address();
        model.addAttribute("address", address);
        request.setAttribute("newAddress", address);
        return "addressForm";
    }

    /**
     * Метод сохранения адреса доставки пользователя
     *
     * @param session
     * @param address
     * @param bindingResult
     * @return
     */
    @PostMapping("/address/saveAddressToUser")
    public String saveAddressToUser(@Valid Address address,
                                    BindingResult bindingResult,
                                    HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "addAddress";
        }
        Object userId = session.getAttribute("id");
        User user = userService.getUser((Long) userId);
        user.addAddressToUser(address);
        userService.updateUser(user);
        return "redirect:/address/listAddress";
    }

    /**
     * Метод получения списка адресов доставки пользователя
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/address/listAddress")
    public String listAddress(Model model, HttpSession session) {
        Object userId = session.getAttribute("id");
        List<Address> addresses = userService.getUser((Long) userId).getAddressList();
        model.addAttribute("addresses", addresses);
        session.setAttribute("addresses", addresses);
        return "listAddress";
    }

    /**
     * Метод отображения формы для редактирования адреса доставки
     *
     * @param id
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/address/updateAddressForm")
    public String showFormUpdateAddress(@RequestParam("id") Long id,
                                        Model model,
                                        HttpSession session) {
        List<Address> addresses = (List<Address>) session.getAttribute("addresses");
        for (Address address : addresses) {
            if (address.getId().equals(id)) ;
            model.addAttribute("address", address);
            session.setAttribute("address", address);
            return "addressForm";
        }
        return "redirect:/address/listAddress";
    }

    /**
     * Метод редактирования адреса доставки
     *
     * @param address
     * @param bindingResult
     * @param session
     * @return
     */
    @PostMapping("/address/updateAddress")
    public String updateAddressToUser(@Valid Address address,
                                      BindingResult bindingResult,
                                      HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "editAddress";
        }
        Object userId = session.getAttribute("id");
        User user = userService.getUser((Long) userId);
        List<Address> addresses = (List<Address>) session.getAttribute("addresses");
        for (Address a : addresses) {
            if (a.getId().equals(address.getId())) {
                a.setId(address.getId());
                a.setAddress(address.getAddress());
                a.setCity(address.getCity());
                a.setCountry(address.getCountry());
                a.setDescription(address.getDescription());
                a.setPostCode(address.getPostCode());
            }
        }
        user.setAddressList(addresses);
        userService.updateUser(user);
        return "redirect:/address/listAddress";
    }

    @GetMapping("/address/deleteAddress")
    public String deleteAddressFromUser(Address address, HttpSession session) {
        Object userID = session.getAttribute("id");
        User user = userService.getUser((Long) userID);
        List<Address> addresses = (List<Address>) session.getAttribute("addresses");
        List<Address> temp = new ArrayList<>();
        for (Address a : addresses) {
            if (!a.getId().equals(address.getId())) {
                temp.add(a);
            }
            user.setAddressList(temp);
        }
        userService.updateUser(user);
        return "redirect:/address/listAddress";
    }
}