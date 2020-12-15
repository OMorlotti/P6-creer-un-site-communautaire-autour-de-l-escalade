package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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
	@Column(name = "numberOfSpit", unique = false, nullable = false)
	private int numberOfSpit;

	/*----------------------------------------------------------------------------------------------------------------*/

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Voie getvoieFK()
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

	public int getNumberOfSpit()
	{
		return numberOfSpit;
	}

	public void setNumberOfSpit(int numberOfSpit)
	{
		this.numberOfSpit = numberOfSpit;
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}
