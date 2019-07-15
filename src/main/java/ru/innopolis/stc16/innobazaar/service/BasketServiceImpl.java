package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.BasketDAO;
import ru.innopolis.stc16.innobazaar.entity.Basket;

import java.util.List;

/**
 * Реализация Service сущности "Корзина"
 */
@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    BasketDAO basketDAO;

    @Override
    public List<Basket> getAllBasket() {
        return basketDAO.getAllBasket();
    }

    @Override
    public void saveBasket(Basket basket) {
        basketDAO.saveBasket(basket);
    }

    @Override
    public Basket getBasket(Long id) {
        return basketDAO.getBasket(id);
    }

    @Override
    public void deleteBasket(Long id) {
        basketDAO.deleteBasket(id);
    }

    @Override
    public void updateBasket(Basket basket) {
        basketDAO.updateBasket(basket);
    }
}



