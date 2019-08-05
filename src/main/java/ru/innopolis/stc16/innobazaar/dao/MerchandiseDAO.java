package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.controller.ProductsSearchCriteria;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;

import java.util.List;

/**
 * DAO "Товар"
 */
public interface MerchandiseDAO {

    List<Merchandise> getAllMerchandise();

    void saveMerchandise(Merchandise merchandise);

    void deleteMerchandise(Long id);

    void updateMerchandise(Merchandise merchandise);

    Merchandise getMerchandise(Long id);

    List<Merchandise> getBySearchCriteria(ProductsSearchCriteria criteria);

    List<Merchandise> getMerchandiseByCategory(String catName);
}
