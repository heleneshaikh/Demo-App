package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by heleneshaikh on 27/03/16.
 */

@Stateless
@LocalBean
public class UserRepository implements RemoteUserRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        user = em.find(User.class, user.getId());
        em.remove(user);

    }

    @Override
    public List<User> findAllUsers() {
        return em.createNamedQuery(User.FIND_ALL, User.class).getResultList();
    }

    @Override
    public void findUserById(Long id) {
        em.find(User.class, id);

    }
}
