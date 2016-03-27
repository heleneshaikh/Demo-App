package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.User;

import java.util.List;

/**
 * Created by heleneshaikh on 27/03/16.
 */
public interface RemoteUserRepository {

    void createUser(User user);

    void deleteUser(User user);

    List<User> findAllUsers();

    void findUserById(Long id);

}
