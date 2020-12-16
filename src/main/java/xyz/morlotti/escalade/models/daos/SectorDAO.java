package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Sector;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SectorDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Sector sector)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(sector);
	}

	public void update (Sector sector)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.merge(sector);
	}

	public void delete(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Sector sector = currentSession.find(Sector.class, id);

		currentSession.delete(sector);
	}

	public Sector get(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		return currentSession.find(Sector.class, id);
	}

	public List<Sector> list() throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		TypedQuery<Sector> query = currentSession.createQuery("SELECT s FROM SECTEUR s", Sector.class);

		return query.getResultList();
	}

	public List list(int parentSpot) throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		/* Dans la requête (qui n'est pas vraiment du SQL), on récupère le bean s (de type Sector):
		 * spotFK (via le getter getSpotFK du bean Sector), on compare l'identifiant id (via le getId)
		 * avec parentSpot pour résoudre la foreign key.
		 */

		TypedQuery<Sector> query = currentSession.createQuery("SELECT s FROM SECTEUR s WHERE s.spotFK.id = ?1", Sector.class);

		return query.setParameter(1, parentSpot).getResultList();
	}
}
