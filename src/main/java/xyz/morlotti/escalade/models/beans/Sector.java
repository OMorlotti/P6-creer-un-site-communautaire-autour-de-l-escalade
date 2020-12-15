package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "SECTEUR")
@Entity(name = "SECTEUR")
public class Sector
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du secteur doit être compris entre 1 et 128 caractères")
	private String name;

	@ManyToOne
	@JoinColumn(name = "spotfk")
	private Spot spotFK;

	/*----------------------------------------------------------------------------------------------------------------*/

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
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

	public Spot getSpotFK()
	{
		return spotFK;
	}

	public void setSpotFK(Spot spotFK)
	{
		this.spotFK = spotFK;
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}
