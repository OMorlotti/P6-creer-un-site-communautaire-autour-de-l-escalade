package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "COTATION")
@Entity(name = "COTATION")
public class Cotation
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = true, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom de la cotation doit être compris entre 1 et 128 caractères")
	private String name;

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

	/*----------------------------------------------------------------------------------------------------------------*/
}
