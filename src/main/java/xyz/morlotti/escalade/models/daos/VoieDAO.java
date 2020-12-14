package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.morlotti.escalade.models.beans.Voie;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VoieDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Voie voie)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(voie);
    }

    public void update(Voie voie)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.merge(voie);
    }

    public void delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Voie voie = currentSession.find(Voie.class, id);

        currentSession.delete(voie);
    }

    public Voie get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(Voie.class, id);
    }

    public List<Voie> list() throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("SELECT u FROM VOIE u");

        return query.list();
    }
}
