package Guide.Server.Models.Repositories;

import Guide.Server.Models.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
