package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.morlotti.escalade.models.beans.Sector;
import xyz.morlotti.escalade.models.beans.Voie;

import javax.persistence.TypedQuery;
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

        TypedQuery<Voie> query = currentSession.createQuery("SELECT u FROM VOIE u", Voie.class);

        return query.getResultList();
    }

    public List<Voie> list(int parentSector) throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        /* Dans la requête (qui n'est pas vraiment du SQL), on récupère le bean s (de type Sector):
         * spotFK (via le getter getSpotFK du bean Sector), on compare l'identifiant id (via le getId)
         * avec parentSpot pour résoudre la foreign key.
         */

        TypedQuery<Voie> query = currentSession.createQuery("SELECT v FROM VOIE v WHERE v.sectorFK.id = ?1", Voie.class);

        return query.setParameter(1, parentSector).getResultList();
    }
}
