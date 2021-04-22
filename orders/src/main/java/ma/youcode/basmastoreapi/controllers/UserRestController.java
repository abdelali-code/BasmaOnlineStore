package ma.youcode.basmastoreapi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, Object> userMap) {
        return null;
    }
}
