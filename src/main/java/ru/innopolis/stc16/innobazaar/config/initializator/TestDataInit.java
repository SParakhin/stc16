package ru.innopolis.stc16.innobazaar.config.initializator;

import ru.innopolis.stc16.innobazaar.entity.Address;
import ru.innopolis.stc16.innobazaar.entity.User;
import ru.innopolis.stc16.innobazaar.service.UserService;

public class TestDataInit {

    private UserService userService;

    public TestDataInit(UserService userService) {
        this.userService = userService;
    }

    private void init() throws Exception {

        User user = new User();
        user.setEmail("ormts@mail.ru");
        user.setFirstName("Sergey");
        user.setLastName("Parakhin");

        Address address = new Address();
        address.setAddress("Pozarnaya");
        address.setCity("Orel");
        address.setCountry("Russia");
        address.setPostCode("302035");

        Address address2 = new Address();
        address2.setAddress("Pozarnaya2");
        address2.setCity("Orel2");
        address2.setCountry("Russia2");
        address2.setPostCode("302035-1");

        user.addAddressToUser(address);
        user.addAddressToUser(address2);
        userService.saveUser(user);
    }
}
