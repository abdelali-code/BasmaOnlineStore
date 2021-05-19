package ma.youcode.basmastoreapi.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
        private ItemBusinessService itemBusinessService;

    @Test
    void dummyItem() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()) // check status
                .andExpect(content().json("{\"id\": 1, \"name\": \"Ball\", \"price\": 10, \"quantity\": 100}")) // check json content
                .andReturn();// helps us to execute requests

        // JSONAssert.assertEquals("{\"id\": 1, \"name\": \"Ball\", \"price\": 10, \"quantity\": 100}", mvcResult.getResponse().getContentAsString(), false);

        // (JSONAssert) strict = true (exact match except for spaces)
        // (JSONAssert) strict = false (except for spaces, exact match and escape character if it is only one word)

    }

    @Test
    void itemFromBusinessService() throws Exception {

        when(itemBusinessService.itemBusinessService())
                .thenReturn(new Item(1, "Ball", 10, 100));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()) // check status
                .andExpect(content().json("{id: 1, name: Ball, price: 10}")) // check json content
                .andReturn();// helps us to execute requests


    }
}