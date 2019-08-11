package ru.innopolis.stc16.innobazaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Сущность "Заказ"
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "booking")
@AllArgsConstructor
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User buyer;

    private String bookingStatus;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<BookedMerchandise> merchandise;

    private Integer count;
    private Date date;
    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;
    private String tracking;

}
