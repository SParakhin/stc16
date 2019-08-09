package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "basket_merchandise",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "merchandise_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Merchandise> merchandises = new CopyOnWriteArrayList<>();

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public Basket(List<Merchandise> merchandises) {
        this.merchandises = merchandises;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}

