package registrationservice.registration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registrationservice.registration.DTO.UserDTO;
import registrationservice.registration.Model.User;
import registrationservice.registration.Repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImplement implements UserService{

    @Autowired
    UserRepository usersRepozitorijum;

    @Override
    public User kreirajKorisnika(UserDTO userDTO) {
        List<User> sviKorisnici = usersRepozitorijum.findAll();

        User noviKorisnik = new User();
        noviKorisnik.setName(userDTO.getName());
        noviKorisnik.setSurname(userDTO.getSurname());



        usersRepozitorijum.save(noviKorisnik);
        return noviKorisnik;
    }
}

