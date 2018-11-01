package Guide.Server.Models.Repositories;

import Guide.Server.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}