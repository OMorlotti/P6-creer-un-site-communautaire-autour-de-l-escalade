package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Address;
import xyz.morlotti.escalade.models.beans.Topo;

import javax.persistence.TypedQuery;
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

        Query query = currentSession.createQuery("SELECT t FROM TOPO t");

        return query.list();
    }

    public List<Topo> list(int parentUser) throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        TypedQuery<Topo> query = currentSession.createQuery("SELECT t FROM TOPO t WHERE t.userFK.id = ?1", Topo.class);

        return query.setParameter(1, parentUser).getResultList();
    }
}
