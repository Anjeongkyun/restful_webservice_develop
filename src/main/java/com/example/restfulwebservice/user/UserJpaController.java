package com.example.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<Users> retrieveAllUsers() {

        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Users retrieveUsers(@PathVariable int id) {

        Optional<Users> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user.get();
    }
}
