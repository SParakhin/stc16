package ru.innopolis.stc16.innobazaar.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.stc16.innobazaar.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Role findRoleByName(String theRoleName) {
        Query query = (Query) entityManager.createQuery("from Role where name=:roleName", Role.class);
        query.setParameter("roleName", theRoleName);
        Role theRole = null;
        try {
            theRole = (Role) query.getSingleResult();
        } catch (Exception e) {
            theRole = null;
        }
        return theRole;
    }
}
