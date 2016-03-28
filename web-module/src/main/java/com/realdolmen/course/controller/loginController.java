package com.realdolmen.course.controller;

import com.realdolmen.course.domain.User;
import com.realdolmen.course.persistence.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by heleneshaikh on 27/03/16.
 */

@Named
@RequestScoped
public class LoginController implements Serializable {

    @Inject
    UserRepository userRepository;

    private User user;
    private String firstName;
    private String lastName;

    public String create() {
        this.user = new User(firstName, lastName, 27);
        userRepository.createUser(this.user);
        return "success";
    }

    public void remove(User user) {
        userRepository.deleteUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


