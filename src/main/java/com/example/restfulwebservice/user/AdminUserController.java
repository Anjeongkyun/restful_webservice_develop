package com.example.restfulwebservice.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    private UserDaoService userDaoService;

    public AdminUserController(UserDaoService userDaoService){
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<User> users = userDaoService.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUsers(@PathVariable int id) {
        User user = userDaoService.findOne(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","ssn");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
