package com.ecommerce.User_Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.User_Service.Model.User;
import com.ecommerce.User_Service.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository ur;

    public List<User> getAllUsers() {
        return ur.findAll();
    }

    public ResponseEntity<User> createUser(User user) {
        User savedUser = ur.save(user);
        return ResponseEntity.ok(savedUser);
    }

    public ResponseEntity<User> getById(int id) {
        return ur.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> updateUser(int id, User user) {

        Optional<User> existingUser = ur.findById(id);

        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User u = existingUser.get();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());

        return ResponseEntity.ok(ur.save(u));
    }

    public ResponseEntity<Void> deleteByid(int id) {

        if (!ur.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        ur.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
