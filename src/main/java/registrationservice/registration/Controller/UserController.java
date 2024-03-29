package registrationservice.registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registrationservice.registration.DTO.BusinessUserPassDTO;
import registrationservice.registration.DTO.UserAndRole;
import registrationservice.registration.DTO.UserDTO;
import registrationservice.registration.DTO.UserPassDTO;
import registrationservice.registration.DTO.UserPassRoleDTO;
import registrationservice.registration.Model.BusinessUser;
import registrationservice.registration.Model.Sex;
import registrationservice.registration.Model.User;
import registrationservice.registration.Repository.BusinessUserRepository;
import registrationservice.registration.Repository.UserRepository;
import registrationservice.registration.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userServis;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessUserRepository businessUserRepository;

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

    @PostMapping("/business")
    public ResponseEntity<BusinessUser> sacuvajBiznisKorisnika(@RequestBody BusinessUserPassDTO businessUserPassDTO){
        BusinessUser b = new BusinessUser();
        b.setUsername(businessUserPassDTO.getUsername());
        b.setEmail(businessUserPassDTO.getEmail());
        b.setWebsite(businessUserPassDTO.getWebsite());
        b.setCompanyName(businessUserPassDTO.getCompanyName());
        businessUserRepository.save(b);

        return new ResponseEntity<BusinessUser>(b,HttpStatus.CREATED);
    }

    @GetMapping("/myProfile")
    public ResponseEntity pronadjiKorisnika(@RequestParam("username") String username, @RequestParam("role") String role) {
        if(role.equals("BusinessUser")){
        BusinessUser businessUser = businessUserRepository.findByUsername(username).orElse(null);
        return new ResponseEntity(businessUser,HttpStatus.OK);
        }

        User user = userRepository.findByUsername(username).orElse(null);
        return new ResponseEntity(user,HttpStatus.OK);

    }
    
    @GetMapping("/findByUsername")
    public ResponseEntity pronadjiKorisnika1(@RequestParam("username") String username) {
        
        
        User user = userRepository.findByUsername(username).orElse(null);
        if(user == null) {
        	 BusinessUser businessUser = businessUserRepository.findByUsername(username).orElse(null);
        	 UserPassRoleDTO x = new UserPassRoleDTO();
        	 x.setUsername(businessUser.getUsername());
        	 x.setRole("BusinessUser");
        	 x.setPassword(businessUser.getPassword());
             return new ResponseEntity(x,HttpStatus.OK);
        }
    
        UserPassRoleDTO x = new  UserPassRoleDTO();
   	 	x.setUsername(user.getUsername());
   	 	x.setRole("User");
   	 	x.setPassword("");
        return new ResponseEntity(x,HttpStatus.OK);

    }
}
