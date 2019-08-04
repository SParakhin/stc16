package ru.innopolis.stc16.innopay.service;

import ru.innopolis.stc16.innopay.entity.Store;

public interface StoreService {

    Store registerStore(String storeName);

    boolean isStoreExists(String storeName);

    boolean authorize(String storeName, String secretKey);

    Store authorizeGet(String storeName, String secretKey);
}
