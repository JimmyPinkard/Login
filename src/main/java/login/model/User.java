package login.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity
 */
@Data
@Entity
@Table(schema = "user")
public class User
{
    /**
     * User's email
     */
    @Id
    @Column(name = "email", nullable = false, unique = true, length = 70)
    private String email;
    /**
     * The user's password
     */
    @Column(name = "password", nullable = false, length = 100)
    private String password;
}
