package xyz.morlotti.escalade.daos;

import java.util.*;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import xyz.morlotti.escalade.beans.User;

@Repository
@Transactional
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

    public List<User> list() throws Exception
    {
        if(sessionFactory == null) throw new Exception("toto");

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("FROM USER");

        return query.list();
    }
}
