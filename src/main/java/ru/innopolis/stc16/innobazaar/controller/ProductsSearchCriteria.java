package ru.innopolis.stc16.innobazaar.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsSearchCriteria {
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    public static final Integer DEFAULT_PAGE_NUMBER = 0;
    public static final String DEFAULT_SORT = "name";


    private String query;
    private List<Long> categoryIds;
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    private Integer pageNumber = DEFAULT_PAGE_NUMBER;
    private String pageSort = DEFAULT_SORT;

}
