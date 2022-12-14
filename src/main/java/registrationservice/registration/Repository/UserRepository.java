package registrationservice.registration.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import registrationservice.registration.Model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String>{

    Optional<User> findByUsername(String username);
}
