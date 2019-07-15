package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.Basket;

import java.util.List;

/**
 * Service сущности "Корзина"
 */
public interface BasketService {

    List<Basket> getAllBasket();

    void saveBasket(Basket basket);

    Basket getBasket(Long id);

    void deleteBasket(Long id);

    void updateBasket(Basket basket);
}
