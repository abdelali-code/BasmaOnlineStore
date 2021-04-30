package ma.youcode.Repositorys;


import ma.youcode.Models.Address;
import ma.youcode.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findAddressByUser(Users user);
}
