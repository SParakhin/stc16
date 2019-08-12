package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.entity.Address;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController {

    private final UserService userService;

    private final HttpSession session;

    public AddressController(UserService userService, HttpSession session) {
        this.userService = userService;
        this.session = session;
    }

    /**
     * Метод для отображения формы добавления адреса доставки для пользователя
     *
     * @param model
     * @return
     */
    @GetMapping("/address/addAddressForm")
    public String showFormAddAddress(@RequestParam(required = false, name = "returnPage") String returnPage, Model model,
                                     HttpServletRequest request) {
        User user = userService.getAuthenticatedUser();
        Address address = new Address();
        model.addAttribute("address", address);
        model.addAttribute("userId", user.getId());
        model.addAttribute("returnPage", returnPage);
        request.setAttribute("newAddress", address);
        return "addressForm";
    }

    /**
     * Метод сохранения адреса доставки пользователя
     *
     * @param address
     * @param bindingResult
     * @return
     */
    @PostMapping("/address/saveAddressToUser")
    public String saveAddressToUser(@RequestParam(required = false, name = "returnPage") String returnPage, @Valid Address address,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addAddress";
        }
        User user = userService.getAuthenticatedUser();
        user.addAddressToUser(address);
        userService.updateUserLinks(user);
        String redirectAddress = "redirect:/address/listAddress";
        if (!returnPage.equals("")) {
            redirectAddress = redirectAddress + "?returnPage=" + returnPage;
        }
        return redirectAddress;
    }

    /**
     * Метод получения списка адресов доставки пользователя
     *
     * @param model
     * @return
     */
    @GetMapping("/address/listAddress")
    public String listAddress(@RequestParam(required = false, name = "returnPage") String returnPage, Model model) {
        User user = userService.getAuthenticatedUser();
        List<Address> addresses = user.getAddressList();
        model.addAttribute("addresses", addresses);
        model.addAttribute("returnPage", returnPage);
        return "listAddress";
    }

    /**
     * Метод отображения формы для редактирования адреса доставки
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/address/updateAddressForm")
    public String showFormUpdateAddress(@RequestParam(required = false, name = "returnPage") String returnPage, @RequestParam("id") Long id,
                                        Model model) {
        User user = userService.getAuthenticatedUser();
        List<Address> addresses = user.getAddressList();
        for (Address address : addresses) {
            if (address.getId().equals(id)) {
                model.addAttribute("address", address);
                model.addAttribute("returnPage", returnPage);
                return "addressForm";
            }
        }
        return "redirect:/address/listAddress";
    }


    /**
     * Метод редактирования адреса доставки
     *
     * @param address
     * @param bindingResult
     * @return
     */
    @PostMapping("/address/updateAddress")
    public String updateAddressToUser(@RequestParam(required = false, name = "returnPage") String returnPage, @Valid Address address,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addressForm";
        }
        User user = userService.getAuthenticatedUser();
        List<Address> addresses = user.getAddressList();
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
        userService.updateUserLinks(user);
        String redirectAddress = "redirect:/address/listAddress";
        if (!returnPage.equals("")) {
            redirectAddress = redirectAddress + "?returnPage=" + returnPage;
        }
        return redirectAddress;
    }

    @GetMapping("/address/deleteAddress")
    public String deleteAddressFromUser(@RequestParam(required = false, name = "returnPage") String returnPage, Address address) {
        User user = userService.getAuthenticatedUser();
        List<Address> addresses = user.getAddressList();
        List<Address> temp = new ArrayList<>();
        for (Address a : addresses) {
            if (!a.getId().equals(address.getId())) {
                temp.add(a);
            }
            user.setAddressList(temp);
        }
        userService.updateUserLinks(user);
        String redirectAddress = "redirect:/address/listAddress";
        if (returnPage != null) {
            redirectAddress = redirectAddress + "?returnPage=" + returnPage;
        }
        return redirectAddress;
    }
}