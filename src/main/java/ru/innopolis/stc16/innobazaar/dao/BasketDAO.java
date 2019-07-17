package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.Basket;

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
}
