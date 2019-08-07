package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    private BigDecimal price=BigDecimal.ZERO;
    private String pictureUrl;

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
}
