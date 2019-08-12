package ru.innopolis.stc16.innobazaar.controller;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc16.innobazaar.config.PayServiceIntegrator;
import ru.innopolis.stc16.innobazaar.entity.*;
import ru.innopolis.stc16.innobazaar.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.stc16.innobazaar.dto.Payment;
import ru.innopolis.stc16.innobazaar.entity.Booking;
import ru.innopolis.stc16.innobazaar.service.BookingService;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;
    private final BookedMerchandiseService bookedMerchandiseService;
    private final StoreService storeService;
    private final HttpSession session;
    private final PayServiceIntegrator payServiceIntegrator;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService, BookedMerchandiseService bookedMerchandiseService, StoreService storeService, HttpSession session, PayServiceIntegrator payServiceIntegrator) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.bookedMerchandiseService = bookedMerchandiseService;
        this.storeService = storeService;
        this.session = session;
        this.payServiceIntegrator = payServiceIntegrator;
    }

    @GetMapping("/bookings/{id}")
    public String getBooking(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBooking(id);
        model.addAttribute("booking", booking);
        return "booking";
    }

    @GetMapping("/bookings")
    public String getBookings(Model model, HttpServletResponse response,
                              HttpServletRequest request) throws ServletException, IOException {
        User user = userService.getAuthenticatedUser();
        if (user == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }
        List<Booking> bookings = refreshPaymentStatus(user);
        List<BigDecimal> totalSums = new ArrayList<>();
        List<Pair<Booking, Map<Store, List<BookedMerchandise>>>> bookingsWithStoresSort = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        for (Booking booking: bookings) {
            BigDecimal totalSum = BigDecimal.ZERO;
            List<BookedMerchandise> bookedMerchandises = booking.getMerchandise();
            Map<Store, List<BookedMerchandise>> merchandisesByStore = new HashMap<>();
            for (BookedMerchandise bookedMerchandise: bookedMerchandises) {
                Store store = bookedMerchandise.getMerchandise().getStore();
                List<BookedMerchandise> merchandiseByStore = merchandisesByStore.get(store);
                if (merchandiseByStore == null) {
                    merchandiseByStore = new ArrayList<>(Arrays.asList(bookedMerchandise));
                } else {
                    merchandiseByStore.add(bookedMerchandise);
                }
                totalSum = totalSum.add(bookedMerchandise.getMerchandise().getPrice().multiply(new BigDecimal(bookedMerchandise.getCount())));
                merchandisesByStore.put(store, merchandiseByStore);
            }
            bookingsWithStoresSort.add(new Pair<>(booking, merchandisesByStore));
            totalSums.add(totalSum);
            dates.add(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(booking.getDate()));
        }
        model.addAttribute("bookingWithStoresSort", bookingsWithStoresSort);
        model.addAttribute("totalSums", totalSums);
        model.addAttribute("dates", dates);
        model.addAttribute("store", payServiceIntegrator.getStore());
        return "mybookings";
    }

    private List<Booking> refreshPaymentStatus(User user) {
        for (Booking booking: user.getBookings()) {
            bookingService.refreshPaymentStatus(booking.getId());
        }
        user = userService.getUser(user.getId());
        return user.getBookings();
    }

    @GetMapping("/booking/create")
    public String createBooking(Model model, HttpServletResponse response,
                                HttpServletRequest request) throws ServletException, IOException {
        User user = userService.getAuthenticatedUser();
        if (user == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }

        Map<Merchandise, Integer> merchandisesWithCount = getMerchandisesWithCount(user);
        Map<Store, List<Pair<Merchandise, Integer>>> merchandisesByStore = new HashMap<>();
        BigDecimal totalSum = new BigDecimal(0);

        for (Map.Entry<Merchandise, Integer> merchandise : merchandisesWithCount.entrySet()) {
            Store store = merchandise.getKey().getStore();
            List<Pair<Merchandise, Integer>> merchandisesAndCount = merchandisesByStore.get(store);
            totalSum = totalSum.add(merchandise.getKey().getPrice().multiply(new BigDecimal(merchandise.getValue())));

            if (merchandisesAndCount == null) {
                merchandisesByStore.put(store, new ArrayList<>(Arrays.asList(new Pair<>(merchandise.getKey(), merchandise.getValue()))));
            } else {
                merchandisesAndCount.add(new Pair<>(merchandise.getKey(), merchandise.getValue()));
                merchandisesByStore.put(store, merchandisesAndCount);
            }
        }
        model.addAttribute("merchandisesByStores", merchandisesByStore);
        model.addAttribute("user", user);
        model.addAttribute("totalSum", totalSum);
        return "createBooking";
    }

    @PostMapping(value = "/booking/save")
    public String saveBooking(AddressForm addressForm,
                              HttpServletResponse response,
                              HttpServletRequest request) throws ServletException, IOException {
        Booking booking = new Booking();
        User user = userService.getAuthenticatedUser();
        if (user == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login");
            dispatcher.forward(request, response);
        }
        Map<Merchandise, Integer> merchandiseWithCount = getMerchandisesWithCount(user);
        List<BookedMerchandise> bookedMerchandises = new ArrayList<>();
        Set<Store> stores = new HashSet<>();
        for(Map.Entry<Merchandise, Integer> merchandise: merchandiseWithCount.entrySet()) {
            BookedMerchandise bookedMerchandise = new BookedMerchandise();
            bookedMerchandise.setMerchandise(merchandise.getKey());
            bookedMerchandise.setCount(merchandise.getValue());
            bookedMerchandises.add(bookedMerchandiseService.save(bookedMerchandise));
            stores.add(merchandise.getKey().getStore());
        }
        booking.setMerchandise(bookedMerchandises);
        booking.setDate(new Date());

        Long addressId = Long.valueOf(addressForm.getAddressId());
        for (Address address: user.getAddressList()) {
            if (address.getId().equals(addressId)) {
                booking.setAddress(address);
                break;
            }
        }
        booking.setBuyer(user);
        booking.setBookingStatus("Заказ оформлен");

        booking = bookingService.saveBooking(booking);
        addBookingToUser(booking, user);
        addBookingToStores(booking, stores);
        user.getMerchandises().clear();
        userService.updateUserLinks(user);
        session.setAttribute("basketSize", 0);
        return "bookingCreated";
    }

    private void addBookingToUser(Booking booking, User user) {
        List<Booking> userBookings = user.getBookings();
        if (userBookings == null) {
            userBookings = new ArrayList<>(Arrays.asList(booking));
        } else {
            userBookings.add(booking);
        }
        user.setBookings(userBookings);
    }

    private void addBookingToStores(Booking booking, Set<Store> stores) {
        for(Store store:stores) {
            List<Booking> storeBookings = store.getBookings();
            if (storeBookings == null) {
                storeBookings = new ArrayList<>(Arrays.asList(booking));
            } else {
                storeBookings.add(booking);
            }
            store.setBookings(storeBookings);
            storeService.updateStore(store);
        }
    }

    private Map<Merchandise,Integer> getMerchandisesWithCount(User user) {
        Map<Merchandise, Integer> merchandises = new HashMap<>();
        for (Merchandise merchandise : user.getMerchandises()) {
            merchandises.merge(merchandise, 1, (a, b) -> a + b);
        }
        return merchandises;
    }

    @GetMapping("/bookings/{id}/paidStatus")
    public String refreshPaymentStatus(@PathVariable Long id, @RequestParam("returnPage") String returnPage, Model model) {
        Payment payment = bookingService.refreshPaymentStatus(id);
        model.addAttribute("payment", payment);
        if (payment != null) {
            model.addAttribute("date", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(payment.getDate()));
        }
        model.addAttribute("returnPage", returnPage);
        return "paymentDetails";
    }

    @GetMapping("/bookings/{id}/details")
    public String getPaymentDetails(@PathVariable Long id, @RequestParam("returnPage") String returnPage, Model model) {
        Payment payment = bookingService.getPayment(id);
        model.addAttribute("payment", payment);
        if (payment != null) {
            model.addAttribute("date", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(payment.getDate()));
        }
        model.addAttribute("returnPage", returnPage);
        return "paymentDetails";
    }

}
