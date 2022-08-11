package login.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Service for sending emails
 */
@Service
public class EmailService
{
    /**
     * Used to send emails
     */
    private final JavaMailSender emailSender;

    /**
     * Constructs email service
     * @param emailSender JavaMailSender instance
     */
    public EmailService(JavaMailSender emailSender)
    {
        this.emailSender = emailSender;
    }

    /**
     * Sends a simple email
     * @param to recipient
     * @param subject subject line
     * @param text message
     */
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dummy@dummy.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
