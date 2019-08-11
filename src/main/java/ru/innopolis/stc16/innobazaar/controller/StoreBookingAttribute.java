package ru.innopolis.stc16.innobazaar.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.innopolis.stc16.innobazaar.entity.Address;
import ru.innopolis.stc16.innobazaar.entity.BookedMerchandise;
import ru.innopolis.stc16.innobazaar.entity.User;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreBookingAttribute {
    private User buyer;
    private String status;
    private List<BookedMerchandise> merchandise;
    private Date date;
    private Address address;
}
