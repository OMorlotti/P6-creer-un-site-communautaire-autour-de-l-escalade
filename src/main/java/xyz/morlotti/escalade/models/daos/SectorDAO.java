package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Sector;

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

	public List list() throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("SELECT u FROM SECTEUR u");

		return query.list();
	}
}
