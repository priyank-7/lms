package com.lms.Services.ServiceImpl;

import com.github.f4b6a3.ulid.UlidCreator;
import com.lms.Entities.Role;
import com.lms.Entities.User;
import com.lms.Exception.ResourceNotFoundException;
import com.lms.Repositories.RoleRepository;
import com.lms.Repositories.UserRepository;
import com.lms.Services.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(String user_id) {
        return this.userRepository.findById(user_id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public User addUser(User user) throws DataIntegrityViolationException {
        user.setUser_id(UlidCreator.getUlid().toString());
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(String user_id) {
        this.userRepository.deleteById(user_id);
    }

    @Override
    public User updateUser(String user_id, User user) throws DataIntegrityViolationException {
        User tempUser = this.userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        tempUser.setEmail(user.getEmail());
        tempUser.setPassword(user.getPassword());
        return this.userRepository.save(tempUser); // unique constraint violation
    }

    @Override
    public User setUserRoles(String user_id, Role role) {
//        User tempUser =  this.userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
//        tempUser.SetRole(this.roleRepository.findByName(role.getName()).orElseThrow(()-> new ResourceNotFoundException("Role not found")));
//        return this.userRepository.save(tempUser);
        return null;
    }
}
