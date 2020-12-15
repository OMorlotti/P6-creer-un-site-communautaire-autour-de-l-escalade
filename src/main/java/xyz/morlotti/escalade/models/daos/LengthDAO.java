package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Length;
import xyz.morlotti.escalade.models.beans.Sector;

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

	public List list() throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("SELECT u FROM LONGUEUR u");

		return query.list();
	}
}
