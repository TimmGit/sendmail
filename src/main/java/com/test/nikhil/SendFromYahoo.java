package com.test.nikhil;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Mail Send program
 * @author nikhil mone
 */
@WebServlet("/SendFromYahoo")
public class SendFromYahoo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Sender's email ID needs to be mentioned
	     String from = "sender@yahoo.in";
	     String pass ="badpassword";
	    // Recipient's email ID needs to be mentioned.
	   String to = "receiver@gmail.com";
	   String host = "smtp.mail.yahoo.com";
	   String output = null;

	   // Get system properties
	   Properties properties = System.getProperties();
	   // Setup mail server
	   properties.put("mail.smtp.starttls.enable", "true");
	   properties.put("mail.smtp.host", host);
	   properties.put("mail.smtp.user", from);
	   properties.put("mail.smtp.password", pass);
	   properties.put("mail.smtp.port", "587");
	   properties.put("mail.smtp.auth", "true");

	   // Get the default Session object.
	   Session session = Session.getDefaultInstance(properties);

	   try{
	      // Create a default MimeMessage object.
	      MimeMessage message = new MimeMessage(session);

	      // Set From: header field of the header.
	      message.setFrom(new InternetAddress(from));

	      // Set To: header field of the header.
	      message.addRecipient(Message.RecipientType.TO,
	                               new InternetAddress(to));

	      // Set Subject: header field
	      message.setSubject("Test Mail");

	      // Now set the actual message
	      message.setText("Hi, this is a test mail");

	      // Send message
	      Transport transport = session.getTransport("smtp");
	      transport.connect(host, from, pass);
	      transport.sendMessage(message, message.getAllRecipients());
	      transport.close();
	      
	      output = "Sent message successfully....";
	      request.setAttribute("output", output);
	      request.getRequestDispatcher("/success.jsp").forward(request, response);
	      
	   }catch (MessagingException mex) {
	      mex.printStackTrace();
	   }
	}

}
