package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/user/{id}")
    public User retrieveUsers(@PathVariable int id) {
        return userDaoService.findOne(id);
    }

    @PostMapping("users")
    public void createUser(@RequestBody User user) {
        User savedUser = userDaoService.save(user);
    }
}
