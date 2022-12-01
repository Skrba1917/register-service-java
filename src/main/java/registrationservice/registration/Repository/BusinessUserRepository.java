package registrationservice.registration.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import registrationservice.registration.Model.BusinessUser;

public interface BusinessUserRepository extends MongoRepository<BusinessUser,String> {
}
