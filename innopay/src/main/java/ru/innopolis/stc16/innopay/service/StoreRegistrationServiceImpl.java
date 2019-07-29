package ru.innopolis.stc16.innopay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innopay.entity.Store;
import ru.innopolis.stc16.innopay.repository.StoreRepository;

import java.util.UUID;

@Service
public class StoreRegistrationServiceImpl implements StoreRegistrationService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreRegistrationServiceImpl(StoreRepository storeRepository) {
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
}
