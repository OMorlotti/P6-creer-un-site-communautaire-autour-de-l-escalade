package xyz.morlotti.escalade;

import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.email.EmailPopulatingBuilder;

import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

public class EmailSingleton
{
	/*----------------------------------------------------------------------------------------------------------------*/

	public static class Attachment
	{
		protected final String m_name;
		protected final String m_mime; // https://fr.wikipedia.org/wiki/Type_de_m%C3%A9dias
		protected final byte[] m_data;

		public Attachment(String name, String mime, byte[] data)
		{
			m_name = name;
			m_mime = mime;
			m_data = data;
		}
	}

	/*----------------------------------------------------------------------------------------------------------------*/

	private EmailSingleton() {}

	/*----------------------------------------------------------------------------------------------------------------*/

	public static void sendMessage(String from, String to, String cc, String subject, String text) throws Exception
	{
		sendMessage(from, to, cc, subject, text, null);
	}

	/*----------------------------------------------------------------------------------------------------------------*/

	public static void sendMessage(String from, String to, String cc, String subject, String text, Attachment[] attachments) throws Exception
	{
		ConfigSingleton configSingleton = new ConfigSingleton();

		String host = configSingleton.getEmailHost();
		String port = configSingleton.getEmailPort();
		String mode = configSingleton.getEmailMode();
		String user = configSingleton.getEmailUser();
		String pass = configSingleton.getEmailPass();

		if(host.isEmpty()
		   ||
		   port.isEmpty()
		   ||
		   mode.isEmpty()
		   ||
		   user.isEmpty()
		   ||
		   pass.isEmpty()
		) {
			return;
		}

		/*------------------------------------------------------------------------------------------------------------*/
		/* CREATE MAILER                                                                                              */
		/*------------------------------------------------------------------------------------------------------------*/

		MailerBuilder.MailerRegularBuilder mailerBuilder = MailerBuilder.withSMTPServer(host, Integer.parseInt(port), user, pass);

		switch(mode.trim())
		{
			case "0":
				mailerBuilder.withTransportStrategy(TransportStrategy.SMTP); // Sans cryptage
				break;

			case "1":
				mailerBuilder.withTransportStrategy(TransportStrategy.SMTPS); // Cryptage SSL
				break;

			case "2":
				mailerBuilder.withTransportStrategy(TransportStrategy.SMTP_TLS); // Cryptage TLS
				break;
		}

		/*------------------------------------------------------------------------------------------------------------*/

		Mailer mailer = mailerBuilder.buildMailer();

		/*------------------------------------------------------------------------------------------------------------*/
		/* CREATE EMAIL                                                                                               */
		/*------------------------------------------------------------------------------------------------------------*/

		EmailPopulatingBuilder emailBuilder = EmailBuilder.startingBlank();

		emailBuilder.from(from);

		to = to.trim();
		if(!to.isEmpty()) {
			emailBuilder.to(to.trim());
		}

		cc = cc.trim();
		if(!cc.isEmpty()) {
			emailBuilder.cc(cc.trim());
		}

		emailBuilder.withSubject(subject).withPlainText(text);

		if(attachments != null)
		{
			for(Attachment attachment: attachments)
			{
				if(attachment != null)
				{
					emailBuilder.withAttachment(
						attachment.m_name,
						attachment.m_data,
						attachment.m_mime
					);
				}
			}
		}

		/*------------------------------------------------------------------------------------------------------------*/

		Email email = emailBuilder.buildEmail();

		/*------------------------------------------------------------------------------------------------------------*/
		/* SEND EMAIL                                                                                                 */
		/*------------------------------------------------------------------------------------------------------------*/

		try
		{
			mailer.sendMail(email);
		}
		catch(RuntimeException e)
		{
			throw new Exception(e);
		}

		/*------------------------------------------------------------------------------------------------------------*/
	}

	/*----------------------------------------------------------------------------------------------------------------*/
}