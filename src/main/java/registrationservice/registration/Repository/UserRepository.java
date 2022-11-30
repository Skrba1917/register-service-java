package registrationservice.registration.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import registrationservice.registration.Model.User;

public interface UserRepository extends MongoRepository<User,String>{
}
