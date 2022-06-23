package com.demo.crud.operation.controller;

import com.demo.crud.operation.beans.Response;
import com.demo.crud.operation.beans.UserDetails;
import com.demo.crud.operation.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class HomeControllerTest {
    @MockBean
    private DataService dataService;

    @Autowired
    private HomeController homeController;

    @Test
    void testDeleteDataById() throws Exception {
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/demo-crud/delete");
        MockHttpServletRequestBuilder requestBuilder = deleteResult.param("Id", String.valueOf(1));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(homeController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void testGetAllUsersDetails() throws Exception {
        when(dataService.getAllDetails()).thenReturn(new Response());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/demo-crud/all");
        MockMvcBuilders.standaloneSetup(homeController).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("{\"statusCode\":0,\"statusMessage\":null}"));
    }

    @Test
    void testGetById() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/demo-crud/id");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("Id", String.valueOf(1));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(homeController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void testSaveUserData() throws Exception {
        UserDetails userDetails = new UserDetails();
        userDetails.setDesignation("Designation");
        userDetails.setId(1);
        userDetails.setName("Name");
        userDetails.setSalary(10.0d);
        when(dataService.addUserData(userDetails)).thenReturn(new Response());
        String content = (new ObjectMapper()).writeValueAsString(userDetails);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/demo-crud/add").contentType(MediaType.APPLICATION_JSON).content(content);
        MockMvcBuilders.standaloneSetup(homeController).build().perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers.content().string("{\"statusCode\":0,\"statusMessage\":null}"));
    }

    @Test
    void testUpdateDataById() throws Exception {
        UserDetails userDetails = new UserDetails();
        userDetails.setDesignation("Designation");
        userDetails.setId(1);
        userDetails.setName("Name");
        userDetails.setSalary(10.0d);
        String content = (new ObjectMapper()).writeValueAsString(userDetails);
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/demo-crud/update");
        MockHttpServletRequestBuilder requestBuilder = putResult.param("Id", String.valueOf(1)).contentType(MediaType.APPLICATION_JSON).content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(homeController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(200));
    }
}

