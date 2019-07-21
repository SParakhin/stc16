package ru.innopolis.stc16.innobazaar.entity;

import lombok.*;
import ru.innopolis.stc16.innobazaar.controller.ProductsSearchCriteria;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchandisePage {
    private List<Merchandise> content;
    private ProductsSearchCriteria criteria;
    private Integer totalElementsNumber;
}
