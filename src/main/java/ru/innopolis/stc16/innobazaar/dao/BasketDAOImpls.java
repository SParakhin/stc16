package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.Basket;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Реализация DAO "Корзина"
 */
@Repository
@Transactional
public class BasketDAOImpls implements BasketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Basket> getAllBasket() {
        return entityManager.createNativeQuery("select * from basket", Basket.class).getResultList();
    }

    @Override
    public void saveBasket(Basket basket) {
        entityManager.persist(basket);
    }

    @Override
    public void deleteBasket(Long id) {
        Basket basket = entityManager.find(Basket.class, id);
        entityManager.remove(basket);
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public void updateBasket(Basket basket) {
        entityManager.merge(basket);
    }

    @Override
    public Basket getBasket(Long id) {
        return entityManager.find(Basket.class, id);
    }

//    @Override
//    public void addMerchandise(Long basketId, Merchandise merchandise) {
//        Basket basket = entityManager.find(Basket.class, basketId);
//        basket.addMerchandise(merchandise);
//        entityManager.persist(basket);
//    }
}
