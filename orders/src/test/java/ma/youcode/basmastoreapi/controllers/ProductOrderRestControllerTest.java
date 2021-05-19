package ma.youcode.basmastoreapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.youcode.basmastoreapi.services.ProductOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductOrderRestController.class)
class ProductOrderRestControllerTest {

    @Autowired
    private MockMvc mockMvc; // to make a request and receive a response

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductOrderService productOrderService;

    @Test
    void testFindAllProductsOrders() {

    }
}