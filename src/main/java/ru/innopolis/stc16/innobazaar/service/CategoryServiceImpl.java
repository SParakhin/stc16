package ru.innopolis.stc16.innobazaar.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.CategoryDAO;
import ru.innopolis.stc16.innobazaar.entity.Category;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
