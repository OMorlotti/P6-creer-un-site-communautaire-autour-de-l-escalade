package xyz.morlotti.escalade.daos;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.morlotti.escalade.beans.User;

public class UserDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(User user)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.persist(user);
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

    public List<User> list()
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("FROM USER");

        return query.list();
    }
}
