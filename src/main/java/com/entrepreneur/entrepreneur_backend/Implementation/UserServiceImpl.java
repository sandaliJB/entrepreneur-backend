package com.entrepreneur.entrepreneur_backend.Implementation;

import com.entrepreneur.entrepreneur_backend.Models.User;
import com.entrepreneur.entrepreneur_backend.Repository.UserRepository;
import com.entrepreneur.entrepreneur_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
    @Override
    public User getUserNameById(String userId) {
        return userRepository.findUsernameByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
    @Override
    public User getUserByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setUserEmail(userDetails.getUserEmail());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setPassword(userDetails.getPassword());
            user.setUserRole(userDetails.getUserRole());
            user.setHomeAddress(userDetails.getHomeAddress());
            user.setMobileNumber(userDetails.getMobileNumber());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}
