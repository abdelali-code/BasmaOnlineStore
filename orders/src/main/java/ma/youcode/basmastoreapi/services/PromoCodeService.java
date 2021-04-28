package ma.youcode.basmastoreapi.services;

import ma.youcode.basmastoreapi.entities.PromoCodeEntity;
import ma.youcode.basmastoreapi.repositories.PromoCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromoCodeService {
    @Autowired
    private PromoCodeRepository promoCodeRepository;

    public PromoCodeEntity getById(Integer idPromoCode) {
        return promoCodeRepository.findById(idPromoCode).get();
    }

    public List<PromoCodeEntity> getAll() {
        return promoCodeRepository.findAll();
    }

    public PromoCodeEntity addOrUpdate(PromoCodeEntity productEntity) {
        return promoCodeRepository.save(productEntity);
    }

    public Boolean deleteById(Integer idPromoCode) {
        promoCodeRepository.deleteById(idPromoCode);
        return true;
    }

}
