package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Booking;
import xyz.morlotti.escalade.models.beans.Comment;
import xyz.morlotti.escalade.models.beans.Spot;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookingDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Booking booking)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(booking);
    }

    public void update(Booking booking)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.merge(booking);
    }

    public void delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Booking booking = currentSession.find(Booking.class, id);

        currentSession.delete(booking);
    }

    public Booking get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(Booking.class, id);
    }

    public List<Booking> list() throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("SELECT b FROM BOOKING b");

        return query.list();
    }

    public List<String> list(int parentTopo) throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        /* Dans la requête (qui n'est pas vraiment du SQL), on récupère le bean c (de type Booking):
         * topotFK (via le getter getTopoFK du bean Booking), on compare l'identifiant id (via le getId)
         * avec parentTopo pour résoudre la foreign key.
         */

        TypedQuery<String> query = currentSession.createQuery("SELECT DISTINCT b.userFK.login FROM BOOKING b WHERE b.topoFK.id = ?1", String.class);

        return query.setParameter(1, parentTopo).getResultList();
    }
}

