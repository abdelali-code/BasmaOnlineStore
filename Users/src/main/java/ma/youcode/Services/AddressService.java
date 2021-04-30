package ma.youcode.Services;

import javassist.NotFoundException;
import ma.youcode.Exceptions.AuthException;
import ma.youcode.Models.Address;
import ma.youcode.Models.Users;
import ma.youcode.Repositorys.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements AddressServiceInterface{



    @Autowired
    AddressRepository addressRepository;


    public Address getUserAddress(Users user) throws NotFoundException {
        Address address = addressRepository.findAddressByUser(user);
        if (address == null) throw new NotFoundException("No address found");
        return address;
    }


    public Boolean createUserAddress(Address address) throws NotFoundException {
        Address address1 = addressRepository.save(address);
        if (getUserAddress(address.getUser()) == null) return false;
        return true;
    }




}


























