package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Сущность Товар
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "merchandise")
public class Merchandise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Store store;
    //TODO private String department;
    //TODO private String productDetail;

    public Merchandise(String name, Store store) {
        this.name = name;
        this.store = store;
    }
}
