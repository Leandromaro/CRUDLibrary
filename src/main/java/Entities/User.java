package Entities;

import org.hibernate.annotations.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
public class User {

    @Id
    public String username;

    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
