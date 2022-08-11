package login.controller;

import login.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST API for emails
 */
@RestController
@RequestMapping("/email")
public class EmailController
{

    /**
     * Used for emailing
     */
    private final EmailService emailService;

    /**
     * Contracts Email Controller
     * @param emailService Instance of EmailService
     */
    public EmailController(final EmailService emailService)
    {
        this.emailService = emailService;
    }

    /**
     * Sends a simple email
     * @param body request body
     * @return Returns the message "email sent"
     */
    @PostMapping("/send")
    public String sendEmail(final @RequestBody Map<String, Object> body)
    {
        emailService.sendSimpleMessage("jimmypinkard7@gmail.com", "We did it!", "Hello World!");
        return "Email sent";
    }
}
