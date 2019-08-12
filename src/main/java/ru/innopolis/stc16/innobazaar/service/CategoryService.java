package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    public Category findCategoryByName(String categoryName);

    void saveCategory(Category category);

    void updateCategory(Category category);

}
