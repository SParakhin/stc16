package ru.innopolis.stc16.innobazaar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.StoreDAO;
import ru.innopolis.stc16.innobazaar.entity.Store;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreDAO storeDAO;

    @Override
    public List<Store> getAllStore() {
        return storeDAO.getAllStore();
    }

    @Override
    public void saveStore(Store store) {
        storeDAO.saveStore(store);
    }

    @Override
    public Store getStore(Long id) {
        return storeDAO.getStore(id);
    }

    @Override
    public void deleteStore(Long id) {
        storeDAO.deleteStore(id);
    }

    @Override
    public void updateStore(Store store) {
        storeDAO.updateStore(store);
    }
}
