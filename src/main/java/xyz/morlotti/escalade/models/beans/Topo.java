package xyz.morlotti.escalade.models.beans;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import xyz.morlotti.escalade.models.BeanException;

@Table(name = "TOPO")
@Entity(name = "TOPO")
public class Topo
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du Topo doit contenir entre 1 et 128 caractères")
	private String name;

	@Column(name = "description", unique = false, nullable = false)
	@Size(min = 1, max = 512, message = "La description doit contenir entre 1 et 512 caractères")
	private String description;

	@Column(name = "city", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "La ville ne doit pas excéder 128 caractères")
	private String city;

	@Column(name = "postalcode", unique = false, nullable = false)
	@Size(min = 2, max = 11, message = "Le code postal ne doit pas excéder 11 caractères")
	private String postalCode;

	@CreationTimestamp
	@Column(name = "releasedate", unique = false, nullable = false)
	private Date releaseDate;

	@Column(name = "isavailable", unique = false, nullable = false)
	private boolean isAvailable;

	@ManyToOne
	@JoinColumn(name = "userfk")
	private User userFK;

	/*----------------------------------------------------------------------------------------------------------------*/

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getReleaseDate()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return simpleDateFormat.format(releaseDate);
	}

	public void setReleaseDate(String releaseDate) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try
		{
			this.releaseDate = simpleDateFormat.parse(releaseDate);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	public boolean getIsAvailable()
	{
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}

	public User getUserFK()
	{
		return userFK;
	}

	public void setUserFK(User userFK)
	{
		this.userFK = userFK;
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}
