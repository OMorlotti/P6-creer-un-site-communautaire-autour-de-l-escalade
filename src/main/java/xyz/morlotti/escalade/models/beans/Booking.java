package xyz.morlotti.escalade.models.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "BOOKING")
@Entity(name = "BOOKING")
public class Booking
{
	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "userfk")
	private User userFK;

	@ManyToOne
	@JoinColumn(name = "topofk")
	private Topo topoFK;

	@Column(name = "isreserved", unique = false, nullable = false)
	private boolean isReserved;

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

	public Topo getTopoFK()
	{
		return topoFK;
	}

	public void setTopoFK(Topo topoFK)
	{
		this.topoFK = topoFK;
	}

	public boolean getIsReserved()
	{
		return isReserved;
	}

	public void setIsReserved(boolean isReserved)
	{
		this.isReserved = isReserved;
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}