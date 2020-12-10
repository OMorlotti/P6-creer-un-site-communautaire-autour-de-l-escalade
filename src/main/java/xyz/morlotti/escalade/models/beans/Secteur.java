package xyz.morlotti.escalade.models.beans;

import xyz.morlotti.escalade.models.BeanException;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "SECTEUR")
@Table(name = "SECTEUR")

public class Secteur
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du secteur doit être compris entre 1 et 128 caractères")
	private String name;

	@OneToMany
	@JoinColumn(name = "spotfk", table = "SPOT")
	private String spotFK;



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

	public String getSpotFK() throws BeanException
	{
		return spotFK;
	}

	public void setSpotFK(String spotFK) throws BeanException
	{
		this.spotFK = spotFK;
	}
}
