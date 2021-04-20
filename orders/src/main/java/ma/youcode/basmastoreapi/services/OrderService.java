package ma.youcode.basmastoreapi.services;

import ma.youcode.basmastoreapi.entities.OrderEntity;
import ma.youcode.basmastoreapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderEntity getById(Long idOrder) {
        return orderRepository.findById(idOrder).get();  // TODO: ADD EXCEPTION FOR WRONG ID
    }

    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    public OrderEntity addOrUpdate(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    public Boolean deleteById(Long idOrder) {
        orderRepository.deleteById(idOrder);
        return true;
    }
}
