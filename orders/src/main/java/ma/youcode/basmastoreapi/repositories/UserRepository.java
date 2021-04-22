package ma.youcode.basmastoreapi.repositories;

import ma.youcode.basmastoreapi.entities.UserEntity;
import ma.youcode.basmastoreapi.exceptions.EtAuthException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email) throws EtAuthException;
}
