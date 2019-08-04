package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Сущность "Заказ"
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "booking")
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User buyer;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BookingStatus bookingStatus;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Store store;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Merchandise merchandise;
    private Integer count;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;
    private String tracking;

    public Booking(User buyer, BookingStatus bookingStatus, Store store, Merchandise merchandise, Date date, Address address, String tracking) {
        this.buyer = buyer;
        this.bookingStatus = bookingStatus;
        this.store = store;
        this.merchandise = merchandise;
        this.date = date;
        this.address = address;
        this.tracking = tracking;
    }
}
