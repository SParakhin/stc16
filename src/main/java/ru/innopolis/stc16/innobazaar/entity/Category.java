package ru.innopolis.stc16.innobazaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Сущность "Раздел магазина"
 * поддерживает вложенность разделов
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @NotEmpty
    @Column(unique = true)
    private String name;

    private String pictureUrl;
}
