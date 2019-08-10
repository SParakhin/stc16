package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.Category;

import java.util.List;


public interface CategoryDAO {
    List<Category> getAllCategories();

    public Category findCategoryByName(String categoryName);

    void saveCategory(Category category);

}
