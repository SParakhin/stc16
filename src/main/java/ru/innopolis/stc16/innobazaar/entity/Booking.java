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
    @Column(columnDefinition = "boolean default false")
    private Boolean paid;

}
