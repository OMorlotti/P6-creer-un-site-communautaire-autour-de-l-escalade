package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Table(name = "LENGTH")
@Entity(name = "LENGTH")
public class Length
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "voiefk")
	private Voie voieFK;

	@ManyToOne
	@JoinColumn(name = "cotationfk")
	private Cotation cotationFK;

	@Min(value = 0)
	@Column(name = "numberOfSpits", unique = false, nullable = false)
	private int numberOfSpits;

	/*----------------------------------------------------------------------------------------------------------------*/

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Voie getVoieFK()
	{
		return voieFK;
	}

	public void setVoieFK(Voie voieFK)
	{
		this.voieFK = voieFK;
	}

	public Cotation getCotationFK()
	{
		return cotationFK;
	}

	public void setCotationFK(Cotation cotationFK)
	{
		this.cotationFK = cotationFK;
	}

	public int getNumberOfSpits()
	{
		return numberOfSpits;
	}

	public void setNumberOfSpits(int numberOfSpits)
	{
		this.numberOfSpits = numberOfSpits;
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}
