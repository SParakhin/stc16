package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.controller.ProductsSearchCriteria;
import ru.innopolis.stc16.innobazaar.entity.Category;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Реализация DAO "Товар"
 */
@Repository
@Transactional
public class MerchandiseDAOImpls implements MerchandiseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Merchandise> getAllMerchandise() {
        return entityManager.createNativeQuery("select * from merchandise", Merchandise.class).getResultList();
    }

    @Override
    public void saveMerchandise(Merchandise merchandise) {
        entityManager.persist(merchandise);
    }

    @Override
    public void deleteMerchandise(Long id) {
        Merchandise merchandise = entityManager.find(Merchandise.class, id);
        entityManager.remove(merchandise);
    }

    @Override
    public void updateMerchandise(Merchandise merchandise) {
        entityManager.merge(merchandise);
    }

    @Override
    public Merchandise getMerchandise(Long id) {
        return entityManager.find(Merchandise.class, id);
    }

    @Override
    public List<Merchandise> getBySearchCriteria(ProductsSearchCriteria criteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Merchandise> query = builder.createQuery(Merchandise.class);
        Root<Merchandise> merchandiseRoot = query.from(Merchandise.class);
        query.select(merchandiseRoot);
        String searchQuery = criteria.getQuery();
        List<Long> categoryIds = criteria.getCategoryIds();
        Predicate queryPredicate = merchandiseNameByQueryPredicate(builder, merchandiseRoot, searchQuery);
        Predicate categoriesPredicate = categoryIdsInListPredicate(merchandiseRoot, categoryIds);

        if (queryPredicate != null && categoriesPredicate != null) {
            query.where(builder.and(categoriesPredicate, queryPredicate));
        } else {
            if (queryPredicate != null) {
                query.where(queryPredicate);
            }
            if (categoriesPredicate != null) {
                query.where(categoriesPredicate);
            }
        }
        addSorting(criteria, builder, query, merchandiseRoot);

        return entityManager.createQuery(query)
                .getResultList();
    }

    private void addSorting(ProductsSearchCriteria criteria, CriteriaBuilder builder, CriteriaQuery<Merchandise> query, Root<Merchandise> merchandiseRoot) {
        Path<Object> sortFiled = merchandiseRoot.get(criteria.getPageSort());
        if (sortFiled == null) {
            sortFiled = merchandiseRoot.get(ProductsSearchCriteria.DEFAULT_SORT);
        }
        query.orderBy(builder.asc(sortFiled));
    }

    private Predicate categoryIdsInListPredicate(Root<Merchandise> merchandiseRoot, List<Long> categoryIds) {
        if (categoryIds != null) {
            Path<Category> category = merchandiseRoot.get("category");
            Expression<Long> categoryId = category.get("id");
            return categoryId.in(categoryIds);
        } else {
            return null;
        }
    }

    private Predicate merchandiseNameByQueryPredicate(CriteriaBuilder builder, Root<Merchandise> merchandiseRoot, String searchQuery) {
        if (!searchQuery.equals("")) {
            return builder
                    .like(builder.lower(merchandiseRoot.get("name")),
                            "%" + searchQuery.toLowerCase() +"%");
        } else {
            return null;
        }
    }
}
