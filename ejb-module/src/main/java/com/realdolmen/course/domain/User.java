package com.realdolmen.course.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by heleneshaikh on 25/03/16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})
public class User {
    public static final String FIND_ALL = "User.findAll";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Transient
    private int age;
    @OneToMany(mappedBy = "user")
    List<Album> albumList;

    public enum Gender {
        MALE, FEMALE
    }
    public User() {
    }

    public User(String firstName, String lastName, Gender gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public static String getFindAll() {
        return FIND_ALL;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
