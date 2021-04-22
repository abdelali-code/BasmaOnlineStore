package ma.youcode.basmastoreapi.services;

import ma.youcode.basmastoreapi.entities.ProductEntity;
import ma.youcode.basmastoreapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity getById(Long idProduct) {
        return productRepository.findById(idProduct).get();  // TODO: ADD EXCEPTION FOR WRONG ID
    }

    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    public ProductEntity addOrUpdate(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public Boolean deleteById(Long idProduct) {
        productRepository.deleteById(idProduct);
        return true;
    }
}
