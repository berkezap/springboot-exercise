package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repos.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    //getirmek için
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    //yaratmak için
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        //custom exception
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {
    return userService.updateOneUser(userId, newUser);
    }
        @DeleteMapping("/{userId}")
        public void deleteOneUser (@PathVariable Long userId){
            userService.deleteById(userId);
        }


}
