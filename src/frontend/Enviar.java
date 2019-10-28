package frontend;

import java.io.File;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * En esta clase se comprueba que en envío por gmail se ha realizado correctamente
 * @author Alumno
 *
 */


public class Enviar 
{
	static boolean enviarConGmail(String user, String contrasena, String destinatario, String asunto, String cuerpo) {
	    Properties emailProperties = new Properties();
	    
	    emailProperties.put("mail.transport.protocol", "smtp");
	    emailProperties.put("mail.smtp.auth", "true");
	    emailProperties.put("mail.smtp.port", "587");
	    emailProperties.put("mail.smtp.socketFactory.port", "465");
	    emailProperties.put("mail.smtp.host", "smtp.gmail.com");
	    emailProperties.put("mail.smtp.ssl.enable", "true");
	    emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    emailProperties.put("mail.debug", "true");
	    emailProperties.put("mail.smtp.user", user);
	    emailProperties.put("mail.smtp.password", contrasena); 
	    emailProperties.put("mail.smtp.starttls.enable", "true");
	    
	 
	 
	    Session session = Session.getInstance(emailProperties, 
	    		new javax.mail.Authenticator() {
	    	protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication (user, contrasena);
	    	}
	    }
	    		);
	    session.setDebug(true);
	    
	    MimeMessage message = new MimeMessage(session);
	    try {

	    	BodyPart texto= new MimeBodyPart();
	        texto.setText(cuerpo);

	        MimeMultipart m=new MimeMultipart();
	        m.addBodyPart(texto);

	        message.setFrom(new InternetAddress(user));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrÃ­an anadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setContent(m);

	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", user, contrasena);
	        transport.sendMessage(message, message.getAllRecipients());

	        transport.close();
	        return true;
    }
    catch (MessagingException me) 
	    {
        return false;
    }
	}


}
