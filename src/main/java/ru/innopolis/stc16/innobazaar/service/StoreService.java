package ru.innopolis.stc16.innobazaar.service;

import ru.innopolis.stc16.innobazaar.entity.Store;

import java.util.List;

public interface StoreService {
    List<Store> getAllStore();

    void saveStore(Store store);

    Store getStore(Long id);

    void deleteStore(Long id);

    void updateStore(Store store);
}
