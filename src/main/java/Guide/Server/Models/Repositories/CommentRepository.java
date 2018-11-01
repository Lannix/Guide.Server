package Guide.Server.Models.Repositories;

import Guide.Server.Models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
