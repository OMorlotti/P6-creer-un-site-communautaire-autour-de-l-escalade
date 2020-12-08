package xyz.morlotti.escalade.beans;

import java.text.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

import xyz.morlotti.escalade.exceptions.BeanException;

@Table(name = "USER")
@Entity(name = "USER")
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

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int m_id;

	@Column(name = "lastname", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Lastname must be between 1 and 128 characters")
	private String m_lastName;

	@Column(name = "firstname", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Firstname must be between 1 and 128 characters")
	private String m_firstName;

	@Column(name = "login", unique = true, nullable = false)
	@Size(min = 4, max = 128, message = "Login must be between 4 and 128 characters")
	private String m_login;

	@Column(name = "password", unique = false, nullable = false)
	@Size(min = 6, max = 128, message = "Password must be between 4 and 128 characters")
	private String m_password;

	@Column(name = "sex", unique = false, nullable = false)
	private Sex m_sex;

	@Column(name = "birthdate", unique = false, nullable = false)
	@Past(message = "Birthdate must be in the past")
	private Date m_birthdate;

	@Column(name = "phone", unique = false, nullable = false)
	@Size(min = 10, max = 16, message = "Phone number must be between 10 and 16 characters")
	private String m_phone;

	@Column(name = "email", unique = true, nullable = false)
	@Email(message = "Email should be valid")
	private String m_email;

	@Column(name = "role", unique = false, nullable = false)
	private Role m_role;

	@Column(name = "custom", unique = false, nullable = true)
	private String m_custom;

	@CreationTimestamp
	@Column(name = "created", unique = false, nullable = false)
	private Date m_created;

	/*----------------------------------------------------------------------------------------------------------------*/

	public int getId()
	{
		return m_id;
	}

	public void setId(int id)
	{
		m_id = id;
	}

	public String getLastName()
	{
		return m_lastName;
	}

	public void setLastName(String lastName)
	{
		m_lastName = lastName;
	}

	public String getFirstName()
	{
		return m_firstName;
	}

	public void setFirstName(String firstName)
	{
		m_firstName = firstName;
	}

	public String getLogin()
	{
		return m_login;
	}

	public void setLogin(String login)
	{
		m_login = login;
	}

	public String getPassword()
	{
		return m_password;
	}

	public void setPassword(String password)
	{
		m_password = password;
	}

	public Sex getSex()
	{
		return m_sex;
	}

	public void setSex(Sex sex)
	{
		m_sex = sex;
	}

	public String getBirthdate()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return simpleDateFormat.format(m_birthdate);
	}

	public void setBirthdate(String birthdate) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try
		{
			m_birthdate = simpleDateFormat.parse(birthdate);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	public String getPhone()
	{
		return m_phone;
	}

	public void setPhone(String phone)
	{
		m_phone = phone;
	}

	public String getEmail()
	{
		return m_email;
	}

	public void setEmail(String email)
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

	public String getCustom()
	{
		return m_custom;
	}

	public void setCustom(String custom)
	{
		m_custom = custom;
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
