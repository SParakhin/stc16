package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.Basket;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;

import java.util.List;

/**
 * DAO "Корзина"
 */
public interface BasketDAO {

    List<Basket> getAllBasket();

    void saveBasket(Basket basket);

    void deleteBasket(Long id);

    void updateBasket(Basket basket);

    Basket getBasket(Long id);

    void addMerchandise(Long basketId, Merchandise merchandise);
}
