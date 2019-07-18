package ru.innopolis.stc16.innobazaar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {


    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)

    public List<User> getAllUser() {
        return entityManager.createQuery("From User").getResultList();
    }

    @Override
    public void deleteUser(Long id) {
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
    public User getUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = entityManager.createQuery("select e FROM User e where e.username=:username");
        query.setParameter("username", username);
        User user = (User) query.getSingleResult();
        return user;
    }
}
