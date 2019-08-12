package ru.innopolis.stc16.innobazaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "booked_merchandise")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookedMerchandise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Merchandise merchandise;
    private Integer count;
}
