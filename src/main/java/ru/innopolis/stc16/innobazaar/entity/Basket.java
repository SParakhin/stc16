package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность "Корзина"
 */
@Entity
@Data
@NoArgsConstructor
@ToString
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "basket_merchandise",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "merchandise_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Merchandise> merchandises;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Basket(List<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }
}

