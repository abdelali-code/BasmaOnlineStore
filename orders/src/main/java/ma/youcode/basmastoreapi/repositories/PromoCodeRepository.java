package ma.youcode.basmastoreapi.repositories;

import ma.youcode.basmastoreapi.entities.PromoCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCodeEntity, Integer> {
    PromoCodeEntity findPromoCodeEntityByCode(String code);
}
