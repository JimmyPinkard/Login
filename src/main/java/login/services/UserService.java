package login.services;

import login.model.User;
import login.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Class for interacting with the User Table in the Database
 */
@Service
public class UserService
{
    /**
     * Used for interfacing with the Database
     */
    private final UserRepository userRepository;
    /**
     * Used for encryption
     */
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs UserService
     * @param userRepository UserRepository instance
     * @param passwordEncoder PasswordEncoder instance
     */
    public UserService(final UserRepository userRepository, final PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Creates users
     * @param body request body
     * @return created user
     */
    public User addUser(final Map<String, Object> body)
    {
        User user = new User();
        user.setEmail((String) body.get("email"));
        user.setPassword(passwordEncoder.encode((String) body.get("password")));
        userRepository.save(user);
        user.setPassword("");
        return user;
    }

    /**
     * Gets a user and checks password
     * @param body request body
     * @return found user
     */
    public User getUser(final Map<String, Object> body)
    {
        User user = userRepository.findById((String) body.get("email")).orElse(null);
        if(user == null)
        {
            return null;
        }
        user.setPassword("");
        return user;
    }

    /**
     * Deletes user
     * @param body request body
     * @return deleted user
     */
    public User deleteUser(final Map<String, Object> body)
    {
        User user = login(body);
        if(user == null)
        {
            return null;
        }
        userRepository.delete(user);
        return user;
    }

    /**
     * Gets a user and checks password
     * @param body request body
     * @return found user
     */
    public User login(final Map<String, Object> body)
    {
        User user = userRepository.findById((String) body.get("email")).orElse(null);
        if(user == null || !passwordEncoder.matches((String)body.get("password"), user.getPassword()))
        {
            return null;
        }
        user.setPassword("");
        return user;
    }
}
