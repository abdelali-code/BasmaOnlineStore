package ma.youcode.basmastoreapi.controllers;

import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item itemBusinessService() {
        return new Item(1, "Ball", 10, 100);
    }
}
