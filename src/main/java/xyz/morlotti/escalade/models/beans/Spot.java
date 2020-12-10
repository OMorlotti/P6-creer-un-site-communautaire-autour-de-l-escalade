package xyz.morlotti.escalade.models.beans;

import xyz.morlotti.escalade.models.BeanException;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "SPOT")
@Table(name = "SPOT")

public class Spot<userFK, topoFK>
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "nom", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du Spot doit être compris entre 1 et 128 caractères")
	private String name;

	@ManyToOne
	@JoinColumn(name = "userfk", table = "USER")
	private User userFK;

	@ManyToOne
	@JoinColumn(name = "topofk", table = "TOPO")
	private Topo topoFK;

	@Column(name = "departement", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du département doit être compris entre 1 et 128 caractères")
	private String departement;

	@Column(name = "latitude", unique = false, nullable = false)
	@Size(min = 4, max = 32, message = "La latitude doit être comprise entre 4 et 32 caractères")
	private String latitude;

	@Column(name = "longitude", unique = false, nullable = false)
	@Size(min = 4, max = 32, message = "La longitude doit être comprise entre 4 et 32 caractères")
	private String longitude;

	@Column(name = "isOfficial", length = 128, nullable = false)
	private boolean isOfficial;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public User getUserFK() throws BeanException
	{
		return userFK;
	}

	public void setUserFK(User userFK) throws BeanException
	{
		this.userFK = userFK;
	}

	public Topo getTopoFK() throws BeanException
	{
		return topoFK;
	}

	public void setTopoFK(Topo topoFK) throws BeanException
	{
		this.topoFK = topoFK;
	}

	public String getDepartement() throws BeanException
	{
		return departement;
	}

	public void setDepartement(String departement) throws BeanException
	{
		this.departement = departement;
	}

	public String getLatitude() throws BeanException
	{
		return latitude;
	}

	public void setLatitude(String latitude) throws BeanException
	{
		this.latitude = latitude;
	}

	public String getLongitude() throws BeanException
	{
		return longitude;
	}

	public void setLongitude(String longitude) throws BeanException
	{
		this.longitude = longitude;
	}

	public boolean isOfficial()
	{
		return isOfficial;
	}

	public void isOfficial(boolean isOfficial)
	{
		this.isOfficial = isOfficial;
	}
}