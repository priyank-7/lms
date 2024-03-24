package com.lms.Services.Service;

import com.lms.Entities.Role;
import com.lms.Entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(String user_id);
    User addUser(User user);
    void deleteUser(String user_id);
    User updateUser(String user_id, User user);
    User setUserRoles(String user_id, Role role);

}
