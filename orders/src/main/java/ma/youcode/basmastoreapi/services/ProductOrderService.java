package ma.youcode.basmastoreapi.services;

import ma.youcode.basmastoreapi.entities.ProductOrderEntity;
import ma.youcode.basmastoreapi.repositories.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    public ProductOrderEntity getById(Long idProductOrder) {
        return productOrderRepository.findById(idProductOrder).get();
    }

    public List<ProductOrderEntity> getAll() {
        return productOrderRepository.findAll();
    }

    public ProductOrderEntity addOrUpdate(ProductOrderEntity productOrderEntity) {
        return productOrderRepository.save(productOrderEntity);
    }

    public boolean deleteById(Long idProductOrder) {
        productOrderRepository.deleteById(idProductOrder);
        return true;
    }
}
