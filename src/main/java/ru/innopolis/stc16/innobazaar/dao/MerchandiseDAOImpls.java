package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.Merchandise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Реализация DAO "Товар"
 */
@Repository
@Transactional
public class MerchandiseDAOImpls implements MerchandiseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Merchandise> getAllMerchandise() {
        return entityManager.createNativeQuery("select * from merchandise", Merchandise.class).getResultList();
    }

    @Override
    public void saveMerchandise(Merchandise merchandise) {
        entityManager.persist(merchandise);
    }

    @Override
    public void deleteMerchandise(Long id) {
        Merchandise merchandise = entityManager.find(Merchandise.class, id);
        entityManager.remove(merchandise);
    }

    @Override
    public void updateMerchandise(Merchandise merchandise) {
        entityManager.merge(merchandise);
    }

    @Override
    public Merchandise getMerchandise(Long id) {
        return entityManager.find(Merchandise.class, id);
    }
}
