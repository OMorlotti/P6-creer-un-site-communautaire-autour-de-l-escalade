package xyz.morlotti.escalade.models.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xyz.morlotti.escalade.models.beans.Address;
import xyz.morlotti.escalade.models.beans.Comment;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(String comment)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(comment);
    }

    public void update(Comment comment)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.merge(comment);
    }

    public void delete(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        Comment comment = currentSession.find(Comment.class, id);

        currentSession.delete(comment);
    }

    public Comment get(int id)
    {
        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.find(Comment.class, id);
    }

    public List<Comment> list() throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        TypedQuery<Comment> query = currentSession.createQuery("SELECT u FROM COMMENT u",Comment.class);

        return query.getResultList();
    }

    public List<Comment> list(int parentSpot) throws Exception
    {
        Session currentSession = sessionFactory.getCurrentSession();

        /* Dans la requête (qui n'est pas vraiment du SQL), on récupère le bean c (de type Comment):
         * spotFK (via le getter getSpotFK du bean Comment), on compare l'identifiant id (via le getId)
         * avec parentSpot pour résoudre la foreign key.
         */

        TypedQuery<Comment> query = currentSession.createQuery("SELECT c FROM COMMENT c WHERE c.spotFK.id = ?1", Comment.class);

        return query.setParameter(1, parentSpot).getResultList();
    }
}

