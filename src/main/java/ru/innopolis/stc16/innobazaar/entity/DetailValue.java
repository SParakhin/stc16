package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Сущность "Значение характеристики"
 * для каждой характеристики администратор системы
 * может создать список допустимых значений
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "detail_value")
public class DetailValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToOne
    private Detail detail;

    @NotEmpty
    private String value;
}
