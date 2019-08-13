package ru.innopolis.stc16.innopay.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * сущность "Оплата"
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "payment", uniqueConstraints={@UniqueConstraint(columnNames = {"store_id" , "custom_payment_id"})})
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Store store;

    @NotNull
    @Column(name = "custom_payment_id")
    private Long customPaymentId;

    @NotNull
    private Date date;

    @NotEmpty
    @Size(min = 16, max = 16)
    private String cardNumber;

    @NotNull
    private BigDecimal amount;
}
