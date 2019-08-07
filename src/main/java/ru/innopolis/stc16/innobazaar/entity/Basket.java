package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @OneToMany(mappedBy = "basket",
            cascade = CascadeType.MERGE,
            targetEntity = Merchandise.class,
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Merchandise> merchandises = new ArrayList<>();
    @OneToOne(mappedBy = "basket")
    private User user;

    public Basket(List<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }

    public boolean addMerchandiseToBasket(Merchandise merchandise) {
        merchandise.setBasket(this);
        return getMerchandises().add(merchandise);
    }
}

