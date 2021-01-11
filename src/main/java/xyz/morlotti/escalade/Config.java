package xyz.morlotti.escalade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config
{
	private String email_host = "";
	private String email_port = "";
	private String email_mode = "";
	private String email_user = "";
	private String email_pass = "";

	// Lecture de la configuration du service dans le fichier "escalade.properties"
	public void load()
	{
		try
		{
			Properties p = new Properties();

			// chargement du fichier escalade.properties depuis le user.home
			String home = System.getProperty("user.home");
			File file = new File(home, "escalade.properties");
			InputStream inputStream = new FileInputStream(file);
			p.load(inputStream);

			// lecture des paramètres
			email_host = p.getProperty("email_host");
			email_port = p.getProperty("email_port");
			email_mode = p.getProperty("email_mode");
			email_user = p.getProperty("email_user");
			email_pass = p.getProperty("email_pass");
		}
		catch(Exception e) // Si le fichier ne peut pas être lu
		{
			System.out.println("MESSAGE A ECRIRE PLUS TARD");
		}

		// Ecriture des paramètres courants dans le fichier de log

		Logger logger = LogManager.getLogger("Config");

		logger.info("email_host: " + email_host);
		logger.info("email_port: " + email_port);
		logger.info("email_mode: " + email_mode);
		logger.info("email_user: " + email_user);
		logger.info("email_pass: " + email_pass);

	}

	// Définition des getters

	public String getEmailHost()
	{
		return email_host;
	}

	public String getEmailPort()
	{
		return email_port;
	}

	public String getEmailMode()
	{
		return email_mode;
	}

	public String getEmailUser()
	{
		return email_user;
	}

	public String getEmailPass()
	{
		return email_pass;
	}
}
