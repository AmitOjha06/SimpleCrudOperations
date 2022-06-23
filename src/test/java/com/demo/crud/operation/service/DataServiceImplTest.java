package com.demo.crud.operation.service;

import com.demo.crud.operation.beans.Response;
import com.demo.crud.operation.beans.UserDetails;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class DataServiceImplTest {
    @Autowired
    private DataServiceImpl dataServiceImpl;

    @Test
    void testGetAllDetails() {
        Response actualAllDetails = dataServiceImpl.getAllDetails();
        assertEquals("Successfully Fetched All Data", actualAllDetails.getStatusMessage());
        assertEquals(200, actualAllDetails.getStatusCode());
    }

    @Test
    void testAddUserData() {
        UserDetails userDetails = new UserDetails(1, "Name", "Designation", 10.0d);
        Response actualAddUserDataResult = dataServiceImpl.addUserData(userDetails);
        assertEquals("Successfully saved All Data", actualAddUserDataResult.getStatusMessage());
        assertEquals(200, actualAddUserDataResult.getStatusCode());
    }

    @Test
    void testGetById() {
        Response actualById = dataServiceImpl.getById(1);
        assertTrue(actualById.getResult() instanceof UserDetails);
        assertEquals("Success", actualById.getStatusMessage());
        assertEquals(200, actualById.getStatusCode());
    }

    @Test
    void testDeleteById() {
        Response actualDeleteByIdResult = dataServiceImpl.deleteById(1);
        assertEquals("Successfully Delete data at id 1", actualDeleteByIdResult.getStatusMessage());
        assertEquals(200, actualDeleteByIdResult.getStatusCode());
    }

    @Test
    void testUpdateData() {
        UserDetails userDetails = new UserDetails(1, "Name", "Designation", 10.0d);
        Response actualUpdateDataResult = dataServiceImpl.updateData(1, userDetails);
        assertEquals("Successfully update the data at id 1", actualUpdateDataResult.getStatusMessage());
        assertEquals(200, actualUpdateDataResult.getStatusCode());
        assertEquals(10.0d, userDetails.getSalary());
        assertEquals("Designation", userDetails.getDesignation());
    }
}

