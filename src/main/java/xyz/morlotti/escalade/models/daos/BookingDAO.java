package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Booking;
import xyz.morlotti.escalade.models.beans.Spot;

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
}

