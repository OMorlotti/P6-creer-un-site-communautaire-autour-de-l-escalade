package xyz.morlotti.escalade.models.beans;

import org.hibernate.annotations.CreationTimestamp;
import xyz.morlotti.escalade.models.BeanException;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "TOPO")
@Table(name = "TOPO")
public class Topo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "name", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom du Topo doit contenir entre 1 et 128 caractères")
	private String nom;

	@Column(name = "description", unique = false, nullable = false)
	@Size(min = 1, max = 512, message = "La description doit contenir entre 1 et 512 caractères")
	private String description;

	@Column(name = "ville", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "La ville ne doit pas excéder 128 caractères")
	private String ville;

	@Column(name = "codepostal", unique = false, nullable = false)
	@Size(min = 2, max = 11, message = "Le code postal ne doit pas excéder 11 caractères")
	private String codePostal;

	@CreationTimestamp
	@Column(name = "dateparution", nullable = false)
	private Date dateParution;

	@Column(name = "isdisponible", nullable = false)
	private boolean isDisponible;

	@ManyToOne
	@JoinColumn(name = "userfk", nullable = false)
	private User userFK;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getNom() throws BeanException
	{
		return nom;
	}

	public void setNom(String nom) throws BeanException
	{
		this.nom = nom;
	}

	public String getDescription() throws BeanException
	{
		return description;
	}

	public void setDescription(String description) throws BeanException
	{
		this.description = description;
	}

	public String getVille(String ville) throws BeanException
	{
		return this.ville;
	}

	public void setVille(String ville) throws BeanException
	{
		this.ville = ville;
	}

	public String getCodePostal() throws BeanException
	{
		return codePostal;
	}

	public void setCodepostal(String codePostal) throws BeanException
	{
		this.codePostal = codePostal;
	}

	public String getDateParution()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return simpleDateFormat.format(dateParution);
	}

	public void setDateParution(String dateParution) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try
		{
			this.dateParution = simpleDateFormat.parse(dateParution);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	public boolean getDisponible()
	{
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible)
	{
		this.isDisponible = isDisponible;
	}

	public User getUserFK() throws BeanException
	{
		if(userFK == null)
		{
			throw new BeanException("L'identifiant d'Utilisateur est vide");
		}

		return userFK;
	}

	public void setUserFK (User userFK) throws BeanException
	{
		if(userFK == null)
		{
			throw new BeanException("L'identifiant d'Utilisateur est vide");
		}

		this.userFK = userFK;
	}
}
