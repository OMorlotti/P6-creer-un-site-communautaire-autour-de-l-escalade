package xyz.morlotti.escalade.models.beans;

import org.hibernate.annotations.CreationTimestamp;
import xyz.morlotti.escalade.models.BeanException;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "COMMENT")
@Entity(name = "COMMENT")
public class Comment
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "spotfk")
	private Spot spotFK;

	@ManyToOne
	@JoinColumn(name = "userfk")
	private User userFK;

	@Column(name = "comment", unique = false, nullable = false)
	@Size(min = 1, max = 512, message = "Le commentaire doit contenir entre 1 et 512 cacartères")
	private String comment;

	@CreationTimestamp
	@Column(name = "created", unique = false, nullable = false)
	private Date created;

	/*----------------------------------------------------------------------------------------------------------------*/

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Spot getSpotFK()
	{
		return spotFK;
	}

	public void setSpotFK(Spot spotFK)
	{
		this.spotFK = spotFK;
	}

	public User getUserFK()
	{
		return userFK;
	}

	public void setUserFK(User userFK)
	{
		this.userFK = userFK;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public String getCreated() throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return simpleDateFormat.format(created);
	}

	public void setCreated(String created) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try
		{
			this.created = simpleDateFormat.parse(created);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}

	/*----------------------------------------------------------------------------------------------------------------*/
	}
}