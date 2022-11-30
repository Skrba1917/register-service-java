package registrationservice.registration.Service;

import registrationservice.registration.DTO.UserDTO;
import registrationservice.registration.Model.User;

public interface UserService {

    public User kreirajKorisnika(UserDTO userDTO);
}
