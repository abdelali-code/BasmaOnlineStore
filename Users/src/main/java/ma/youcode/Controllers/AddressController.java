package ma.youcode.Controllers;


import javassist.NotFoundException;
import ma.youcode.Models.Address;
import ma.youcode.Models.Users;
import ma.youcode.Services.AddressServiceInterface;
import ma.youcode.Services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AddressController {


    @Autowired
    private AddressServiceInterface addressService;
    @Autowired
    private UserServiceInterface userService;



    @PostMapping("/user/address")
    public ResponseEntity<? extends  Object> addAddress(@RequestBody Map<String , String> address, HttpServletRequest request){
        Map<String , String > msg = new HashMap<>();
        try {
            Optional<Users> user = userService.getByID(Long.parseLong(address.get("user_Id")));
            Boolean addresAdded = addressService.createUserAddress(new Address(address.get("gander"),
                    address.get("phone"), address.get("address"), address.get("city"), address.get("country"), user.get()));
            msg.put("message", "Address added successfully");
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (NotFoundException e) {
            msg.put("message", e.getMessage());
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/user/address/{user_id}")
    public ResponseEntity<? extends  Object> getUserAddress(@PathVariable("user_id") Long user_id){
        Map<String , Object > msg = new HashMap<>();
        try {
            Optional<Users> user = userService.getByID(user_id);
            Address address = addressService.getUserAddress(user.get());
            msg.put("message", address);
            return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        } catch (NotFoundException e) {
            msg.put("message", e.getMessage());
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
    }




}
