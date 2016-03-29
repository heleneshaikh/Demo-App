package com.realdolmen.course.controller;

import com.realdolmen.course.domain.User;
import com.realdolmen.course.persistence.UserRepository;
import org.hibernate.validator.constraints.Length;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private User user;
    @NotNull @Length(min = 1, max = 30)
    private String firstName;
    @NotNull @Length(min = 1, max = 30)
    private String lastName;
    private User.Gender gender;


    public String create() {
        this.user = new User(firstName, lastName, gender, 27);
        userRepository.createUser(this.user);
        return "success";
    }

    public void validateName(FacesContext facesContext, UIComponent toValidate, Object value) throws ValidatorException {
        String lastName = (String) value;
        if (lastName.length() < 3) {
            FacesMessage message = new FacesMessage("last name is too short");
            throw new ValidatorException(message);
        }
    }
    //event listener:
    public void action(ActionEvent event) {
        System.out.println("Hello!");
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

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User.Gender getGender() {
        return gender;
    }

    public void setGender(User.Gender gender) {
        this.gender = gender;
    }
}


