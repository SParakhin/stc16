package ru.innopolis.stc16.innobazaar.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Сущность "Отзывы"
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User reviewer;
    private String description;

    public Reviews(User reviewer, String description) {
        this.reviewer = reviewer;
        this.description = description;
    }
}

