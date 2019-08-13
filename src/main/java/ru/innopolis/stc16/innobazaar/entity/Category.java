package ru.innopolis.stc16.innobazaar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

    @NotEmpty(message = "необходимо заполнить")
    @Size(max = 255, message = "не длиннее 255 символов")
    @Column(unique = true)
    private String name;

    @NotEmpty(message = "необходимо заполнить")
    @Size(max = 255, message = "не длиннее 255 символов")
    private String pictureUrl;
}
