package ru.innopolis.stc16.innobazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc16.innobazaar.entity.*;
import ru.innopolis.stc16.innobazaar.service.StoreService;
import ru.innopolis.stc16.innobazaar.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StoreController {

    private final UserService userService;

    private final HttpSession session;

    private final StoreService storeService;

    public StoreController(UserService userService, HttpSession session, StoreService storeService) {
        this.userService = userService;
        this.session = session;
        this.storeService = storeService;
    }

    /**
     * Метод отображения формы для добавления магазина пользователю
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/store/addStoreForm")
    public String showFormAddStore(Model model,
                                   HttpServletRequest request) {
        User user = userService.getAuthenticatedUser();
        Store store = new Store();
        model.addAttribute("store", store);
        model.addAttribute("userId", user.getId());
        request.setAttribute("newStore", store);
        return "storeForm";
    }

    /**
     * Метод для сохраения магазина пользователя
     *
     * @param store
     * @param bindingResult
     * @return
     */
    @PostMapping("/store/saveStoreToUser")
    public String saveStoreToUser(@Valid Store store,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addAddress";
        }
        User user = userService.getAuthenticatedUser();
        user.addStoreToUser(store);
        userService.updateUserLinks(user);
        return "redirect:/store/listStore";
    }

    /**
     * Метод получения списка магазинов пользователя
     * * @param model
     *
     * @return
     */
    @GetMapping("/store/listStore")
    public String listStore(Model model) {
        User user = userService.getAuthenticatedUser();
        List<Store> stores = user.getStoreList();
        model.addAttribute("stores", stores);
        return "listStore";
    }

    /**
     * Метод отображения формы для редактирования магазина
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/store/updateStoreForm")
    public String showFormUpdateAddress(@RequestParam("id") Long id,
                                        Model model) {
        User user = userService.getAuthenticatedUser();
        List<Store> stores = user.getStoreList();
        for (Store store : stores) {
            if (store.getId().equals(id)) {
                model.addAttribute("store", store);
                return "storeForm";
            }
        }
        return "redirect:/store/listStore";
    }


    /**
     * Метод редактирования магазина
     *
     * @param store
     * @param bindingResult
     * @return
     */
    @PostMapping("/store/updateStore")
    public String updateStoreToUser(@Valid Store store,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "storeForm";
        }
        User user = userService.getAuthenticatedUser();
        List<Store> stores = user.getStoreList();
        for (Store s : stores) {
            if (s.getId().equals(store.getId())) {
                s.setId(store.getId());
                s.setDescription(store.getDescription());
                s.setName(store.getName());
            }
        }
        user.setStoreList(stores);
        userService.updateUserLinks(user);
        return "redirect:/store/listStore";
    }

    /**
     * Метод удаления магазина
     *
     * @param store
     * @return
     */
    @GetMapping("/store/deleteStore")
    public String deleteStoreFromUser(Store store) {
        User user = userService.getAuthenticatedUser();
        List<Store> stores = user.getStoreList();
        List<Store> temp = new ArrayList<>();
        for (Store s : stores) {
            if (!s.getId().equals(store.getId())) {
                temp.add(s);
            }
            user.setStoreList(temp);
        }
        userService.updateUserLinks(user);
        return "redirect:/store/listStore";
    }

    /**
     * Метод отображения главной страницы магазина для владельца магазина. Выводит:
     * контакты магазина
     * список товаров магазина
     * список заказов магазина
     *
     * @param model
     * @return
     */
    @GetMapping("/store")
    public String showStore(@RequestParam(value = "id", required = false) Long id,
                            Model model) {
        User user = userService.getAuthenticatedUser();
        List<Store> stores = user.getStoreList();
        Store store = null;
        if (id == null) {
            id = (Long) session.getAttribute("storeId");
            for (Store s : stores) {
                if (s.getId().equals(id)) {
                    store = storeService.getStore(id);
                }
            }
        } else {
            for (Store s : stores) {
                if (s.getId().equals(id)) {
                    store = s;
                }
            }
        }
        session.setAttribute("storeId", store.getId());
        List<Merchandise> products = store.getMerchandiseList();
        model.addAttribute("store", store);
        model.addAttribute("user", user);
        model.addAttribute("products", products);
        model.addAttribute("bookings", extractStoreMerchandises(store, store.getBookings()));
        return "store";
    }

    /**
     * Метод для отображения магазина для покупателя (витрина магазина). Скрывает кнопки владельца магазина
     */
    @GetMapping("/store/{id}")
    public String showStoreForCustomer(@PathVariable("id") Long id,
                                       Model model) {
        Store store = storeService.getStore(id);
        List<Merchandise> products = store.getMerchandiseList();
        model.addAttribute("store", store);
        model.addAttribute("products", products);
        model.addAttribute("bookings", extractStoreMerchandises(store, store.getBookings()));
        return "store";
    }

    private List<StoreBookingAttribute> extractStoreMerchandises(Store store, List<Booking> bookings) {
        List<StoreBookingAttribute> storeBookingAttributes = new ArrayList<>();
        for (Booking booking: bookings) {
            StoreBookingAttribute storeBookingAttribute = new StoreBookingAttribute();
            storeBookingAttribute.setId(booking.getId());
            storeBookingAttribute.setAddress(booking.getAddress());
            storeBookingAttribute.setStatus(booking.getBookingStatus());
            storeBookingAttribute.setBuyer(booking.getBuyer());
            storeBookingAttribute.setDate(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(booking.getDate()));
            storeBookingAttribute.setPaid(booking.getPaid());
            List<BookedMerchandise> merchandises = booking.getMerchandise();
            List<BookedMerchandise> merchandisesForStore = new ArrayList<>();
            BigDecimal price = BigDecimal.ZERO;
            for(BookedMerchandise bookedMerchandise: merchandises) {
                if (bookedMerchandise.getMerchandise().getStore().equals(store)) {
                    merchandisesForStore.add(bookedMerchandise);
                    price = price.add(bookedMerchandise.getMerchandise().getPrice().multiply(BigDecimal.valueOf(bookedMerchandise.getCount())));
                }
            }
            storeBookingAttribute.setMerchandise(merchandisesForStore);
            storeBookingAttribute.setPrice(price);
            storeBookingAttributes.add(storeBookingAttribute);
        }
        return storeBookingAttributes;
    }
}
