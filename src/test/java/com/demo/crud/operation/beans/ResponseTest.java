package com.demo.crud.operation.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ResponseTest {

    @Test
    void testConstructor() {
        Response actualResponse = new Response();
        actualResponse.setResult("Result");
        actualResponse.setStatusCode(1);
        actualResponse.setStatusMessage("Status Message");
        String actualToStringResult = actualResponse.toString();
        assertEquals(1, actualResponse.getStatusCode());
        assertEquals("Status Message", actualResponse.getStatusMessage());
        assertEquals("Response(statusCode=1, statusMessage=Status Message, result=Result)", actualToStringResult);
    }

    @Test
    void testConstructor2() {
        Response actualResponse = new Response(1, "Status Message", "Result");
        String actualToStringResult = actualResponse.toString();
        assertEquals(1, actualResponse.getStatusCode());
        assertEquals("Status Message", actualResponse.getStatusMessage());
        assertEquals("Response(statusCode=1, statusMessage=Status Message, result=Result)", actualToStringResult);
    }
}

