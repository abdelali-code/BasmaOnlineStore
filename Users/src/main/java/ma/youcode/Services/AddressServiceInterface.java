package ma.youcode.Services;

import javassist.NotFoundException;
import ma.youcode.Models.Address;
import ma.youcode.Models.Users;

public interface AddressServiceInterface {


    Address getUserAddress(Users user) throws NotFoundException;
    Boolean createUserAddress(Address address) throws NotFoundException;
}
