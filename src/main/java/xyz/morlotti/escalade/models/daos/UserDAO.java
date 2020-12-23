package xyz.morlotti.escalade.models.daos;

import java.util.*;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.morlotti.escalade.models.beans.User;

@Repository
@Transactional
public class UserDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(User user)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(user);
    }

    public void update(User user)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.merge(user);
    }

    public void delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        User user = currentSession.find(User.class, id);

        currentSession.delete(user);
    }

    public User get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(User.class, id);
    }

    public User get(String login, String password)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        TypedQuery<User> query = currentSession.createQuery("SELECT u FROM USER u WHERE u.login = ?1 AND u.password = ?2", User.class);

        return query.setParameter(1, login)
                    .setParameter(2, password)
                    .getSingleResult()
        ;
    }

    public List<User> list() throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        TypedQuery<User> query = currentSession.createQuery("SELECT u FROM USER u", User.class);

        return query.getResultList();
    }
}
