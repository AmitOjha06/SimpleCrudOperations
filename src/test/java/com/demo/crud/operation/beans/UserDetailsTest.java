package com.demo.crud.operation.beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDetailsTest {

    @Test
    void testConstructor() {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(1);
        userDetails.setName("Name");
        userDetails.setSalary(120.09);
        userDetails.setDesignation("Designation");
        assertEquals(1, userDetails.getId());
        assertEquals("Name", userDetails.getName());
        assertEquals(120.09, userDetails.getSalary());
        assertEquals("Designation", userDetails.getDesignation());
    }

    @Test
    void testConstructor1() {
        UserDetails userDetails = new UserDetails(1, "Name", "Designation", 120.09);
        assertEquals(1, userDetails.getId());
        assertEquals("Name", userDetails.getName());
        assertEquals(120.09, userDetails.getSalary());
        assertEquals("Designation", userDetails.getDesignation());
    }
}
