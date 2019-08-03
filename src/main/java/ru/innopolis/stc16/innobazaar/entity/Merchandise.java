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

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            targetEntity = Category.class)
//    @JoinTable(name = "categories_merchandises",
//            joinColumns = @JoinColumn(name = "merchandise_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
//    private List<Category> categories = new ArrayList<>();
    @OneToOne(targetEntity = Category.class)
    @JoinTable(name = "categories_merchandises",
            joinColumns = @JoinColumn(name = "merchandise_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Category category;
    private String categoryName;
    private String productDetail;
    private BigDecimal price;
    private String pictureUrl;

    public Merchandise(String name, String description, Store store, Category category, BigDecimal price, String pictureUrl) {
        this.name = name;
        this.store = store;
        this.description = description;
        this.category = category;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

//    public void addCategory(Category category) {
//        categories.add(category);
//    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
