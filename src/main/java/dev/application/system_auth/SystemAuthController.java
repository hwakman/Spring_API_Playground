package dev.application.system_auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SystemAuthController {

    @Autowired
    SystemAuthRepository systemAuthRepository;

    @GetMapping("")
    public List<SystemAuth> getAll () {
        List<SystemAuth> auth = new ArrayList<>();
        systemAuthRepository.findAll().forEach(auth::add);

        return auth;
    }

    @PostMapping("/add")
    public String addAuth (
        @RequestParam(value = "user_id") String user_id,
        @RequestParam(value = "user_name") String user_name,
        @RequestParam(value = "password") String password
    ) {
        try {
            SystemAuth sa = new SystemAuth();
            sa.setUser_id(user_id);
            sa.setUser_name(user_name);
            sa.setPassword(password);
            systemAuthRepository.save(sa);

            return "Value added";
        } catch (Exception e) {

            return "Error : " + e;
        }
    }

    @PostMapping("/del")
    public String delAuth (@RequestParam(value = "id") Long id) {
        try {
            systemAuthRepository.deleteById(id);
            
            return "delete value id '"+id+"'.";
        } catch (Exception e) {
            
            return "Error : " + e;
        }
    }
}