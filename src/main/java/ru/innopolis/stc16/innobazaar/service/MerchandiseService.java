package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.controller.ProductsSearchCriteria;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;
import ru.innopolis.stc16.innobazaar.entity.MerchandisePage;

import java.util.List;

/**
 * Service сущности "Товар"
 */
public interface MerchandiseService {

    List<Merchandise> getAllMerchandise();

    void saveMerchandise(Merchandise merchandise);

    Merchandise getMerchandise(Long id);

    void deleteMerchandise(Long id);

    void updateMerchandise(Merchandise merchandise);

    MerchandisePage getBySearchCriteria(ProductsSearchCriteria criteria);
}
