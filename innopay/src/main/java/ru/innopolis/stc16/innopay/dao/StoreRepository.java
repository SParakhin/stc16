package ru.innopolis.stc16.innopay.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc16.innopay.entity.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {

    Store getStoreByName(String storeName);

    Store getStoreByNameAndSecretKey(String storeName, String secretKey);
}
