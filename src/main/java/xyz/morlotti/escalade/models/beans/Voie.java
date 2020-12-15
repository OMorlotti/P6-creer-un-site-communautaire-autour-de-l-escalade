package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Table(name = "VOIE")
@Entity(name = "VOIE")
public class Voie
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Min(value = 0)
	@Column(name = "height", unique = false, nullable = false)
	private float height;

	@ManyToOne
	@JoinColumn(name = "secteurfk")
	private Sector secteurFK;

	/*----------------------------------------------------------------------------------------------------------------*/

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public float getHeight()
	{
		return height;
	}

	public void setHeight(float height)
	{
		this.height = height;
	}

	public Sector getSecteurFK()
	{
		return secteurFK;
	}
	public void setSecteurFK(Sector secteurFK)
	{
		this.secteurFK = secteurFK;
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}
