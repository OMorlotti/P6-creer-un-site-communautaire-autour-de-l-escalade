package xyz.morlotti.escalade.models.beans;

import java.io.Serializable;
import java.text.*;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;
import xyz.morlotti.escalade.models.BeanException;

@Table(name = "USER")
@Entity(name = "USER")
public class User implements Serializable
{
	/*----------------------------------------------------------------------------------------------------------------*/

	public enum Sex
	{
		F("F"), M("M");

		private final String value;

		private Sex(String value) /* Une valeur d'enum est comme une classe, elle peut avoir un constructeur et des méthodes : https://stackoverflow.com/questions/13291076/java-enum-why-use-tostring-instead-of-name */
		{
			this.value = value;
		}

		@Override
		public String toString() /* Pour convertir une valeur d'enum en String */
		{
			return value;
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
		GUEST("GUEST"), USER("USER"), MEMBER("MEMBER"), ADMIN("ADMIN");

		private final String value;

		private Role(String value)
		{
			this.value = value;
		}

		@Override
		public String toString() /* Pour convertir une valeur d'enum en String */
		{
			return value;
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
			else if("ADMIN".equalsIgnoreCase(value))
			{
				return ADMIN;
			}

			throw new BeanException("Ne peut pas parser la valeur du role");
		}
	}

	/*----------------------------------------------------------------------------------------------------------------*/

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "lastname", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le nom de famille doit être compris entre 1 et 128 caractères")
	private String lastName;

	@Column(name = "firstname", unique = false, nullable = false)
	@Size(min = 1, max = 128, message = "Le prénom doit être compris entre 1 et 128 caractères")
	private String firstName;

	@Column(name = "login", unique = true, nullable = false)
	@Size(min = 4, max = 128, message = "Le login doit être compris entre 4 et 128 caractères")
	private String login;

	@Column(name = "password", unique = false, nullable = false)
	@Size(min = 6, max = 128, message = "Le mot de passe doit être compris entre 6 et 128 caractères")
	private String password;

	@Column(name = "sex", unique = false, nullable = false)
	private Sex sex;

	@Column(name = "birthdate", unique = false, nullable = false)
	@Past(message = "La date de naissance est forcément dans le passé :-)")
	private Date birthdate;

	@Column(name = "phone", unique = false, nullable = false)
	@Size(min = 10, max = 16, message = "Le numéro de téléphone doit être compris entre 10 et 16 caractères")
	private String phone;

	@Column(name = "email", unique = true, nullable = false)
	@Email(message = "L'email doit être valide")
	private String email;

	@Column(name = "role", unique = false, nullable = false)
	private Role role;

	@Column(name = "custom", unique = false, nullable = true)
	private String custom;

	@CreationTimestamp
	@Column(name = "created", unique = false, nullable = false)
	private Date created;

	/*----------------------------------------------------------------------------------------------------------------*/

	public void initGuest()
	{
		Date currentDate = new Date();

		this.id = -1;
		this.lastName = "guest";
		this.firstName = "guest";
		this.login = "guest";
		this.password = "guest";
		this.sex = Sex.M;
		this.birthdate = currentDate;
		this.phone = "";
		this.email = "guest@guest.com";
		this.role = User.Role.GUEST;
		this.custom = "";
		this.created = currentDate;
	}

	/*----------------------------------------------------------------------------------------------------------------*/

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLogin()
	{
		return login;
	}

	public void setLogin(String login)
	{
		this.login = login;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Sex getSex()
	{
		return sex;
	}

	public void setSex(Sex sex)
	{
		this.sex = sex;
	}

	public String getBirthdate()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		return simpleDateFormat.format(birthdate);
	}

	public void setBirthdate(String birthdate) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try
		{
			this.birthdate = simpleDateFormat.parse(birthdate);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}

	public String getCustom()
	{
		return custom;
	}

	public void setCustom(String custom)
	{
		this.custom = custom;
	}

	public String getCreated() throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		return simpleDateFormat.format(created);
	}

	public void setCreated(String created) throws BeanException
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try
		{
			this.created = simpleDateFormat.parse(created);
		}
		catch(ParseException e)
		{
			throw new BeanException(e);
		}
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}
