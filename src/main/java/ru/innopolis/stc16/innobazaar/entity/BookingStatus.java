package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность "Статус Заказа"
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "booking_status")
public class BookingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String description;

    public BookingStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }
}
