package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Topo;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TopoDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Topo topo)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(topo);
    }

    public void update(Topo topo)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.merge(topo);
    }

    public void delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Topo topo = currentSession.find(Topo.class, id);

        currentSession.delete(topo);
    }

    public Topo get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(Topo.class, id);
    }

    public List<Topo> list() throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("SELECT u FROM TOPO u");

        return query.list();
    }
}
