package ma.youcode.basmastoreapi.repositories;


import ma.youcode.basmastoreapi.entities.ProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, Long> {
}
