package xyz.morlotti.escalade.beans;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import xyz.morlotti.escalade.exceptions.BeanException;

import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User
{
	/*----------------------------------------------------------------------------------------------------------------*/

	public enum Sex
	{
		F("F"), M("M");

		private final String m_value;

		private Sex(String value) /* Une valeur d'enum est comme une classe, elle peut avoir un constructeur et des méthodes : https://stackoverflow.com/questions/13291076/java-enum-why-use-tostring-instead-of-name */
		{
			m_value = value;
		}

		@Override
		public String toString() /* Pour convertir une valeur d'enum en String */
		{
			return m_value;
		}

		public static Sex parseSex(String value) throws BeanException /* Pour convertir une chaîne en une valeur d'enum */
		{
			/**/ if("F".equalsIgnoreCase(value))
			{
				return F;
			}
			else if("M".equalsIgnoreCase(value))
			{
				return M;
			}

			throw new BeanException("Ne peut pas parser la valeur du sexe");
		}
	}

	/*----------------------------------------------------------------------------------------------------------------*/

	public enum Role
	{
		GUEST("GUEST"), USER("USER"), MEMBER("MEMBER");

		private final String m_value;

		private Role(String value)
		{
			m_value = value;
		}

		@Override
		public String toString() /* Pour convertir une valeur d'enum en String */
		{
			return m_value;
		}

		public static Role parseRole(String value) throws BeanException
		{
			/**/ if("GUEST".equalsIgnoreCase(value))
			{
				return GUEST;
			}
			else if("USER".equalsIgnoreCase(value))
			{
				return USER;
			}
			else if("MEMBER".equalsIgnoreCase(value))
			{
				return MEMBER;
			}

			throw new BeanException("Ne peut pas parser la valeur du role");
		}
	}

	/*----------------------------------------------------------------------------------------------------------------*/

	private String m_id;

	@Size(min = 1, max = 128, message = "Lastname must be between 1 and 128 characters")
	private String m_nom;

	@Size(min = 1, max = 128, message = "Firstname must be between 1 and 128 characters")
	private String m_prenom;

	@Size(min = 4, max = 128, message = "Login must be between 4 and 128 characters")
	private String m_login;

	@Size(min = 6, max = 128, message = "Password must be between 4 and 128 characters")
	private String m_password;

	private Sex m_sexe;

	@Past(message = "Birth date must be in the past")
	private Date m_dateDeNaissance;

	@Size(min = 10, max = 16, message = "Phone number must be between 10 and 16 characters")
	private String m_telephone;

	@Email(message = "Email should be valid")
	private String m_email;

	private Role m_role;

	private String m_divers;

	private Date m_created;

	/*----------------------------------------------------------------------------------------------------------------*/

	public String getId()
	{
		return m_id;
	}

	public void setId(String id)
	{
		m_id = id;
	}

	public String getNom() throws BeanException
	{
		return m_nom;
	}

	public void setNom(String nom) throws BeanException
	{
		m_nom = nom;
	}

	public String getPrenom() throws BeanException
	{
		return m_prenom;
	}

	public void setPrenom(String prenom) throws BeanException
	{
		m_prenom = prenom;
	}

	public String getLogin() throws BeanException
	{
		return m_login;
	}

	public void setLogin(String login) throws BeanException
	{
		m_login = login;
	}

	public String getPassword() throws BeanException
	{
		return m_password;
	}

	public void setPassword(String password) throws BeanException
	{
		m_password = password;
	}

	public Sex getSexe()
	{
		return m_sexe;
	}

	public void setSexe(Sex sex)
	{
		m_sexe = sex;
	}

	public String getDateDeNaissance() throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return simpleDateFormat.format(m_dateDeNaissance);
	}

	public void setDateDeNaissance(String dateDeNaissance) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			m_dateDeNaissance = simpleDateFormat.parse(dateDeNaissance);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	public String getTelephone() throws BeanException
	{
		return m_telephone;
	}

	public void setTelephone(String telephone) throws BeanException
	{
		m_telephone = telephone;
	}

	public String getEmail() throws BeanException
	{
		return m_email;
	}

	public void setEmail(String email) throws BeanException
	{
		m_email = email;
	}

	public Role getRole()
	{
		return m_role;
	}

	public void setRole(Role role)
	{
		m_role = role;
	}

	public String getDivers()
	{
		return m_divers;
	}

	public void setDivers(String divers)
	{
		m_divers = divers;
	}

	public String getCreated() throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return simpleDateFormat.format(m_created);
	}

	public void setCreated(String created) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try
		{
			m_created = simpleDateFormat.parse(created);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}
