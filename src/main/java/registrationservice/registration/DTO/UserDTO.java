package registrationservice.registration.DTO;

import registrationservice.registration.Model.User;

public class UserDTO {

    private String name;

    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public UserDTO(User user){
        this(user.getName(), user.getSurname());

    }
}
