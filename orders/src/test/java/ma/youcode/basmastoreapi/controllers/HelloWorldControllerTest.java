package ma.youcode.basmastoreapi.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Using Mock Mvc to test Hello World Controller

@ExtendWith(SpringExtension.class) // this is a Spring unit test
@WebMvcTest(HelloWorldController.class) // test only this Specific controller and contains MockMvc Bean
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
        // call '/hello'
        // create a request for GET '/hello' and response is type of application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()) // check status
                .andExpect(content().string("Hello World")) // check expected content
                .andReturn();// helps us to execute requests

        // verify "Hello World"
        // assertEquals("Hello World", mvcResult.getResponse().getContentAsString()); (uncomment that when you not use andExcept method)
    }
}