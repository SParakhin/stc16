package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.MerchandiseDAO;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;

import java.util.List;

/**
 * Реализация Service сущности "Товара"
 */
@Service
public class MerchandiseServiceImpl implements MerchandiseService {

    @Autowired
    MerchandiseDAO merchandiseDAO;

    @Override
    public List<Merchandise> getAllMerchandise() {
        return merchandiseDAO.getAllMerchandise();
    }

    @Override
    public void saveMerchandise(Merchandise merchandise) {
        merchandiseDAO.saveMerchandise(merchandise);
    }

    @Override
    public Merchandise getMerchandise(Long id) {
        return merchandiseDAO.getMerchandise(id);
    }

    @Override
    public void deleteMerchandise(Long id) {
        merchandiseDAO.deleteMerchandise(id);
    }

    @Override
    public void updateMerchandise(Merchandise merchandise) {
        merchandiseDAO.updateMerchandise(merchandise);
    }
}

