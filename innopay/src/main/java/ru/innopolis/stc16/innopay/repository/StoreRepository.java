package ru.innopolis.stc16.innopay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc16.innopay.entity.Store;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
}
