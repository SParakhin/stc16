package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.Store;

import java.util.List;

public interface StoreDAO {

    List<Store> getAllStore();

    void saveStore(Store store);

    Store getStore(int id);

    void deleteStore(int id);

    void updateStore(Store store);
}
