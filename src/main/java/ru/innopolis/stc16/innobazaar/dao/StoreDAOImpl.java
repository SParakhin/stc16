package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.Store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@Transactional
public class StoreDAOImpl implements StoreDAO {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)

    public List<Store> getAllStore() {
        return entityManager.createQuery("From Store").getResultList();
    }

    @Override
    public void deleteStore(Long id) {
        Store store = entityManager.find(Store.class, id);
        entityManager.remove(store);
    }

    @Override
    public void updateStore(Store store) {
        entityManager.merge(store);
    }

    @Override
    @NotNull
    public void saveStore(Store store) {
        entityManager.persist(store);
    }

    @Override
    public Store getStore(Long id) {
        return entityManager.find(Store.class, id);
    }
}
