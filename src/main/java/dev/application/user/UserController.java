package dev.application.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public List<User> getUser () {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    @PostMapping("/add")
    public String addUser (
        @RequestParam(value = "name") String name,
        @RequestParam(value = "email") String email
    ) {
        try {
            User users = new User();
            users.setName(name);
            users.setEmail(email);
            userRepository.save(users);

            return "Value added";
        } catch (Exception e) {

            return "Error : " + e;
        }
    }

    @PostMapping("/del")
    public String removeUser (
        @RequestParam(value = "id") Long id
    ) {
        try {
            userRepository.deleteById(id);

            return "User id '"+id+"' was deleted.";
        } catch (Exception e) {
            
            return "Error :" + e;
        }
    }
}