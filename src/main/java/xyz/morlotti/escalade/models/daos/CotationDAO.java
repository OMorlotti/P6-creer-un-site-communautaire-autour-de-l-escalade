package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Cotation;
import xyz.morlotti.escalade.models.beans.Length;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CotationDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Cotation cotation)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(cotation);
	}

	public void update (Cotation cotation)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.merge(cotation);
	}

	public void delete(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Cotation cotation = currentSession.find(Cotation.class, id);

		currentSession.delete(cotation);
	}

	public Cotation get(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		return currentSession.find(Cotation.class, id);
	}

	public List list() throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("SELECT u FROM COTATION u");

		return query.list();
	}
}
