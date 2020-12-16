package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Address;
import xyz.morlotti.escalade.models.beans.Spot;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AddressDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Address address)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(address);
    }

    public void update(Address address)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.merge(address);
    }

    public void delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Address address = currentSession.find(Address.class, id);

        currentSession.delete(address);
    }

    public Address get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(Address.class, id);
    }

    public List<Address> list() throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("SELECT u FROM ADDRESS u");

        return query.list();
    }
}

