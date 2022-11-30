package registrationservice.registration.Model;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "users")
public class User {


	private String username;
    private String name;
    private String surname;
    private Sex sex;
    private int age;
    private String city;


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
    
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User(){

    }

//

}
