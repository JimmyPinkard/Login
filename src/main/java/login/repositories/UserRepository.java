package login.repositories;

import login.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Used for interfacing with repositories
 */
@Repository
public interface UserRepository extends CrudRepository<User, String>
{
}
