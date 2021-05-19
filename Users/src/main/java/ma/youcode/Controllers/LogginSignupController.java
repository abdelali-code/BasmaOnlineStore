package ma.youcode.Controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import ma.youcode.Exceptions.AuthException;
import ma.youcode.Models.UserRequest;
import ma.youcode.Models.Users;
import ma.youcode.Services.EmailServiceImpl;
import ma.youcode.Services.UserServiceInterface;
import ma.youcode.Ulits.Token;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*")
public class LogginSignupController {
    @Autowired
    private UserServiceInterface userService;
    @Autowired
    private Token token;

    @Autowired
    private EmailServiceImpl emailService;


    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody Map<String, String> user) {
        //TODO send email when the user register
        System.out.println("user " + user);

        Map<String, String> msg = new HashMap<>();
        try {
            System.out.println(user.get("fullName") + user.get("email") + user.get("password") + user.get("type"));
            Users usr = userService.createAccountService(user.get("fullName"), user.get("email"), user.get("password"));
            msg.put("message", "Account created successfully, please check your email.");
            //emailService.sendConfirmationEmail(user.get("email"), "Confirm your email!",
                                          //      "Please verifies your Basmashop account by clicking this link : http://localhost:8081/api/account/validation/" + token.generateurJWTTokern(usr).get("token"));

            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }
        catch (Exception e) {
            msg.put("message", e.getMessage());
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }

    }


    @PostMapping("/login")
    public ResponseEntity<? extends Object> login(@RequestBody UserRequest user) throws AuthException {

        System.out.println("the users " + user.getEmail() + user.getPassword());

        Map<String, String> msg = new HashMap<>();
        try {
            Users usr = userService.loginService(user.getEmail(), user.getPassword());
            //return the token
            return new ResponseEntity<>(token.generateurJWTTokern(usr), HttpStatus.OK);
        } catch (AuthException e) {
            System.out.println("authentication failed");
            msg.put("message", e.getMessage());
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/account/validation/{token}")
    public ResponseEntity<? extends Object> emailValidation(@PathVariable("token") String token){
        if (token == null) throw new AuthException("This link isn't working anymore");
        Map<String , String> msg = new HashMap<>();
        try {
            //parse the String into json
            Claims claims = Jwts.parser().setSigningKey("onlineshopapi").parseClaimsJws(token).getBody();
            userService.confirmEmail(Long.parseLong(claims.get("Id").toString()));
            msg.put("massage", "Your email was confirmed successfully.");
            return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            msg.put("massage", "Sorry! this link not working anymore.");
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }
}
