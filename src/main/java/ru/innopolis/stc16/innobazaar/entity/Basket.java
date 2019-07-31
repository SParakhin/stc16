package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Сущность "Корзина"
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Merchandise> merchandise;

    public Basket(List<Merchandise> merchandise) {
        this.merchandise = merchandise;
    }

    public void addMerchandise(Merchandise merchandiseItem) {
        if (merchandise == null) {
            merchandise = new LinkedList<>();
            merchandise.add(merchandiseItem);
        }
    }
}

