package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Сущность "Характеристика"
 * для товарного раздела можно указать набор характеристик товара,
 * специфичных для этого раздела
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToOne
    private Category category;

    @NotEmpty
    @Column(unique = true)
    private String name;
}
