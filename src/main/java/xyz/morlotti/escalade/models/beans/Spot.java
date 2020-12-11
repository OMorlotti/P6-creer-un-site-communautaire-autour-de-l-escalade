package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "SPOT")
@Entity(name = "SPOT")
public class Spot
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "nom", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du Spot doit être compris entre 1 et 128 caractères")
	private String name;

	@ManyToOne
	@JoinColumn(name = "userfk")
	private User userFK;

	@ManyToOne
	@JoinColumn(name = "topofk")
	private Topo topoFK;

	@Column(name = "departement", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du département doit être compris entre 1 et 128 caractères")
	private String departement;

	@Column(name = "latitude", unique = false, nullable = false)
	@Size(min = 6, max = 32, message = "La latitude doit être comprise entre 6 et 32 caractères")
	private String latitude;

	@Column(name = "longitude", unique = false, nullable = false)
	@Size(min = 6, max = 32, message = "La longitude doit être comprise entre 6 et 32 caractères")
	private String longitude;

	@Column(name = "isofficial", unique = false, nullable = false)
	private boolean isOfficial;

	/*----------------------------------------------------------------------------------------------------------------*/

	public String getId()
	{
		return id;
	}

	public void setId(String id)
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

	public User getUserFK()
	{
		return userFK;
	}

	public void setUserFK(User userFK)
	{
		this.userFK = userFK;
	}

	public Topo getTopoFK()
	{
		return topoFK;
	}

	public void setTopoFK(Topo topoFK)
	{
		this.topoFK = topoFK;
	}

	public String getDepartement()
	{
		return departement;
	}

	public void setDepartement(String departement)
	{
		this.departement = departement;
	}

	public String getLatitude()
	{
		return latitude;
	}

	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}

	public String getLongitude()
	{
		return longitude;
	}

	public void setLongitude(String longitude)
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

	/*----------------------------------------------------------------------------------------------------------------*/
}