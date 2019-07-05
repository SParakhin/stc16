package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.util.List;

import ru.innopolis.stc16.innobazaar.entity.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {


    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)

    public List<User> getAllUser() {
        return entityManager.createNativeQuery("select * from users", User.class).getResultList();
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @NotNull
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
}
