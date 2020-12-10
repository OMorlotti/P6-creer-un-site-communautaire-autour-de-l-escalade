package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Spot;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SpotDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Spot spot)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(spot);
    }

    public void update(Spot spot)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.merge(spot);
    }

    public void delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Spot spot = currentSession.find(Spot.class, id);

        currentSession.delete(spot);
    }

    public Spot get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(Spot.class, id);
    }

    public List<Spot> list() throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("SELECT u FROM SPOT u");

        return query.list();
    }
}

