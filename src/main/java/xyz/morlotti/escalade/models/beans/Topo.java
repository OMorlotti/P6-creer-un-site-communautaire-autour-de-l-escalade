package xyz.morlotti.escalade.models.beans;

import org.hibernate.annotations.CreationTimestamp;
import xyz.morlotti.escalade.models.BeanException;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "TOPO")
@Table(name = "TOPO")
public class Topo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du Topo doit contenir entre 1 et 128 caractères")
	private String name;

	@Column(name = "description", unique = false, nullable = false)
	@Size(min = 1, max = 512, message = "La description doit contenir entre 1 et 512 caractères")
	private String description;

	@Column(name = "city", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "La ville ne doit pas excéder 128 caractères")
	private String city;

	@Column(name = "postalCode", unique = false, nullable = false)
	@Size(min = 2, max = 11, message = "Le code postal ne doit pas excéder 11 caractères")
	private String postalCode;

	@CreationTimestamp
	@Column(name = "dateparution", nullable = false)
	private Date releaseDate;

	@Column(name = "isAvailable", nullable = false)
	private boolean isAvailable;

	@ManyToOne
	@JoinColumn(name = "userfk", table = "USER")
	private User userFK;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName() throws BeanException
	{
		return name;
	}

	public void setName(String name) throws BeanException
	{
		this.name = name;
	}

	public String getDescription() throws BeanException
	{
		return description;
	}

	public void setDescription(String description) throws BeanException
	{
		this.description = description;
	}

	public String getCity(String city) throws BeanException
	{
		return this.city;
	}

	public void setCity(String city) throws BeanException
	{
		this.city = city;
	}

	public String getPostalCode() throws BeanException
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode) throws BeanException
	{
		this.postalCode = postalCode;
	}

	public String releaseDate()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return simpleDateFormat.format(releaseDate);
	}

	public void setReleaseDate(String releaseDate) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try
		{
			this.releaseDate = simpleDateFormat.parse(releaseDate);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	public boolean getAvailable()
	{
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}

	public User getUserFK() throws BeanException
	{
		if(userFK == null)
		{
			throw new BeanException("L'identifiant d'Utilisateur est vide");
		}

		return userFK;
	}

	public void setUserFK (User userFK) throws BeanException
	{
		if(userFK == null)
		{
			throw new BeanException("L'identifiant d'Utilisateur est vide");
		}

		this.userFK = userFK;
	}
}
