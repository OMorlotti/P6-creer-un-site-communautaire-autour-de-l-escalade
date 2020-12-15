package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
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

	@Column(name = "height", unique = false, nullable = false)
	@Size(min = 0, max = 9999, message = "La hauteur doit être comprise entre 0 et 9999 mètres")
	private int height;

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

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
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
