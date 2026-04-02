package com.ecommerce.User_Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.User_Service.Model.User;
import com.ecommerce.User_Service.Service.UserService;

@RestController
@RequestMapping("/ecomm/users")
public class UserController {

    @Autowired
    private UserService us;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    // Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        return us.getById(id);
    }

    // Create user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return us.createUser(user);
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable int id,
            @RequestBody User user) {
        return us.updateUser(id, user);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        return us.deleteByid(id);
    }
}
