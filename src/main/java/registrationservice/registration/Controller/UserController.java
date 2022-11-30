package registrationservice.registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import registrationservice.registration.DTO.UserDTO;
import registrationservice.registration.DTO.UserPassDTO;
import registrationservice.registration.Model.Sex;
import registrationservice.registration.Model.User;
import registrationservice.registration.Repository.UserRepository;
import registrationservice.registration.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userServis;
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/")
    public ResponseEntity<User> sacuvajKorisnika(@RequestBody UserPassDTO userPassDTO){
    	User x = new User();
    	x.setAge(userPassDTO.getAge());
    	x.setCity(userPassDTO.getCity());
    	x.setName(userPassDTO.getName());
    	x.setSex(Sex.valueOf(userPassDTO.getSex()));
    	x.setSurname(userPassDTO.getSurname());
    	x.setUsername(userPassDTO.getUsername());
    	userRepository.save(x);
    	
        return new ResponseEntity<User>(x, HttpStatus.CREATED);
    }
}
