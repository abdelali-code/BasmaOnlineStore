package ma.youcode.basmastoreapi.services;

import ma.youcode.basmastoreapi.entities.UserEntity;
import ma.youcode.basmastoreapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity getById(Long idUser) {
        return userRepository.findById(idUser).get();  // TODO: ADD EXCEPTION FOR WRONG ID
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity addOrUpdate(UserEntity productEntity) {
        return userRepository.save(productEntity);
    }

    public Boolean deleteById(Long idUser) {
        userRepository.deleteById(idUser);
        return true;
    }
}
