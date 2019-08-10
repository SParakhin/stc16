package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Сущность "Товар"
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
    private String description;
    @ManyToOne
    private Store store;
    //TODO private String department;
    //TODO private String productDetail;
    @ManyToOne
    private Category category;
    @Transient
    private String categoryName;
    private String productDetail;
    private BigDecimal price = BigDecimal.ZERO;
    private String pictureUrl;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "basket_merchandise",
            joinColumns = @JoinColumn(name = "merchandise_id"),
            inverseJoinColumns = @JoinColumn(name = "basket_id"))
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Basket> basketList;

    public Merchandise(String name, String description, Store store, Category category, BigDecimal price, String pictureUrl) {
        this.name = name;
        this.store = store;
        this.description = description;
        this.category = category;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "category=" + category +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", price=" + price +
                ", productDetail='" + productDetail + '\'' +
                ", store=" + store +
                '}';
    }
}
