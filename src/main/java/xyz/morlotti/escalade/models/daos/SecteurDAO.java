package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Secteur;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class SecteurDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void add(Secteur secteur)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.save(secteur);
	}

	public void update (Secteur secteur)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.merge(secteur);
	}

	public void delete(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Secteur secteur = currentSession.find(Secteur.class, id);

		currentSession.delete(secteur);
	}

	public Secteur get(int id)
	{
		Session currentSession = sessionFactory.getCurrentSession();

		return currentSession.find(Secteur.class, id);
	}

	public List list() throws Exception
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("SELECT u FROM SECTEUR u");

		return query.list();
	}
}
