package xyz.morlotti.escalade.models.beans;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Table(name = "ADDRESS")
@Entity(name = "ADDRESS")
public class Address
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "userfk")
	private User userFK;

	@Column(name = "street", unique = false, nullable = false)
	@Size(min = 1, max = 6, message = "Le numéro de voie doit être compris entre 1 et 6 caractères")
	private String street;

	@Column(name = "streetname", unique = false, nullable = false)
	@Size(min = 1, max = 256, message = "Le nom de voie doitdoit être compris entre 1 et 256 caractères")
	private String streetName;

	@Column(name = "postalcode", unique = false, nullable = false)
	@Size(min = 2, max = 11, message = "La taille du code postal doit être comprise entre 2 et 11 caractères")
	private String postalCode;

	@Column(name = "city", unique = false, nullable = false)
	@Size(min = 6, max = 32, message = "La taille de la ville doit être comprise entre 6 et 32 caractères")
	private String city;

	@Column(name = "country", unique = false, nullable = false)
	@Size(min = 6, max = 32, message = "La taille du pays doit être comprise entre 6 et 32 caractères")
	private String country;

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

	public User getUserFK()
	{
		return userFK;
	}

	public void setUserFK(User userFK)
	{
		this.userFK = userFK;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getStreetName()
	{
		return streetName;
	}

	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}