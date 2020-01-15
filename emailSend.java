import java.util.*;
import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

class emailSend{
	public static void main(String[] args) {
		String recipient = "f20180167@hyderabad.bits-pilani.ac.in";
		String sender = "ameetesh01@gmail.com";
		String host = "smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.host",host);
		props.put("mail.smtp.user", sender);
    	props.put("mail.smtp.password", "bhadralok@01");
    	props.put("mail.smtp.port", "465"); 
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {    
        protected PasswordAuthentication getPasswordAuthentication() {    
        return new PasswordAuthentication(sender, "bhadralok@01");  
       }    
      });

		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("This is the second subject");
			message.setText("This the second message");
			Transport transport = session.getTransport("smtp");
        	transport.connect("smtp.gmail.com",465,"ameetesh01@gmail.com", "bhadralok@01");
        	transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Mail successfully sent");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}