package login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for index.html
 */
@Controller
public class ViewController
{
    /**
     * Routes the index page
     * @return index.html
     */
    @GetMapping({"/", "/home", "/index"})
    public String index()
    {
        return "index";
    }
}
