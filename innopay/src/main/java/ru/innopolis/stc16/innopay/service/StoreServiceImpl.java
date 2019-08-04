package ru.innopolis.stc16.innopay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innopay.entity.Store;
import ru.innopolis.stc16.innopay.dao.StoreRepository;

import java.util.UUID;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store registerStore(String storeName) {
        Store newStore = new Store();
        newStore.setName(storeName);
        newStore.setSecretKey(UUID.randomUUID().toString());
        try {
            storeRepository.save(newStore);
        } catch (Exception e) {
            return null;
        }
        return newStore;
    }

    @Override
    public boolean isStoreExists(String storeName) {
        Store store;
        try {
            store = storeRepository.getStoreByName(storeName);
        } catch (Exception e) {
            store = null;
        }
        return store != null;
    }

    @Override
    public boolean authorize(String storeName, String secretKey) {
        try {
            Store store = storeRepository.getStoreByNameAndSecretKey(storeName, secretKey);
            return store != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Store authorizeGet(String storeName, String secretKey) {
        try {
            return storeRepository.getStoreByNameAndSecretKey(storeName, secretKey);
        } catch (Exception e) {
            return null;
        }
    }
}
