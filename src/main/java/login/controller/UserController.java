package login.controller;

import login.services.UserService;
import login.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * REST API for Users
 */
@RestController
@RequestMapping("/users")
public class UserController
{
    /**
     * Used to abstract Database interactions
     */
    private final UserService userService;

    /**
     * Constructs User Controller
     * @param userService instance of User Service
     */
    public UserController(final UserService userService)
    {
        this.userService = userService;
    }

    /**
     *HTTP Request to add User
     * @param body request body
     * @return new user
     */
    @PostMapping("/add")
    public User addUser(@RequestBody final Map<String, Object> body)
    {
        return userService.addUser(body);
    }

    /**
     *HTTP Request to get User
     * @param body request body
     * @return user
     */
    @PostMapping("/get")
    public User getUser(@RequestBody final Map<String, Object> body)
    {
        return userService.getUser(body);
    }

    /**
     *HTTP Request to delete User
     * @param body request body
     * @return deleted user
     */
    @PostMapping("/delete")
    public User deleteUser(@RequestBody final Map<String, Object> body)
    {
        return userService.deleteUser(body);
    }

    /**
     *HTTP Request to login
     * @param body request body
     * @return user
     */
    @PostMapping("/login")
    public User login(@RequestBody final Map<String, Object> body)
    {
        return userService.login(body);
    }
}
