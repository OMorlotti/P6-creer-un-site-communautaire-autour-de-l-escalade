package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Length;
import xyz.morlotti.escalade.models.beans.Sector;
import xyz.morlotti.escalade.models.beans.Voie;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class LengthDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Length length)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(length);
	}

	public void update (Length length)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.merge(length);
	}

	public void delete(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Length length = currentSession.find(Length.class, id);

		currentSession.delete(length);
	}

	public Length get(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		return currentSession.find(Length.class, id);
	}

	public List<Length> list() throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		TypedQuery<Length> query = currentSession.createQuery("SELECT u FROM LENGTH u", Length.class);

		return query.getResultList();
	}

	public List<Length> list(int parentVoie) throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		/* Dans la requête (qui n'est pas vraiment du SQL), on récupère le bean s (de type Sector):
		 * spotFK (via le getter getSpotFK du bean Sector), on compare l'identifiant id (via le getId)
		 * avec parentSpot pour résoudre la foreign key.
		 */

		TypedQuery<Length> query = currentSession.createQuery("SELECT l FROM LENGTH l WHERE l.voieFK.id = ?1", Length.class);

		return query.setParameter(1, parentVoie).getResultList();
	}
}
