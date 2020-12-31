package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Address;

import javax.persistence.TypedQuery;
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

        TypedQuery<Address> query = currentSession.createQuery("SELECT u FROM ADDRESS u", Address.class);

        return query.getResultList();
    }

    public List<Address> list(int parentUser) throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        /* Dans la requête (qui n'est pas vraiment du SQL), on récupère le bean s (de type Sector):
         * spotFK (via le getter getSpotFK du bean Sector), on compare l'identifiant id (via le getId)
         * avec parentSpot pour résoudre la foreign key.
         */

        TypedQuery<Address> query = currentSession.createQuery("SELECT a FROM ADDRESS a WHERE a.userFK.id = ?1", Address.class);

        return query.setParameter(1, parentUser).getResultList();
    }
}
