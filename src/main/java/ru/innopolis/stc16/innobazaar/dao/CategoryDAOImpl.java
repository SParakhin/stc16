package ru.innopolis.stc16.innobazaar.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> getAllCategories() {
        return entityManager.createNativeQuery("select * from category", Category.class).getResultList();
    }

    @Override
    public Category findCategoryByName(String categoryName) {
        Query query = (Query) entityManager.createQuery("from Category where name=:categoryName", Category.class);
        query.setParameter("categoryName", categoryName);
        Category category = null;
        try {
            category = (Category) query.getSingleResult();
        } catch (Exception e) {
            category = null;
        }
        return category;
    }

    @Override
    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    @Override
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

}