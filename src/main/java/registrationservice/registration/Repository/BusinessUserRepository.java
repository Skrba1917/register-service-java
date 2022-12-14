package registrationservice.registration.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import registrationservice.registration.Model.BusinessUser;

import java.util.Optional;

public interface BusinessUserRepository extends MongoRepository<BusinessUser,String> {

    Optional<BusinessUser>findByUsername(String username);
}
