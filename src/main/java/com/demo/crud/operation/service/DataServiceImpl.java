package com.demo.crud.operation.service;

import com.demo.crud.operation.beans.Response;
import com.demo.crud.operation.beans.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    List<UserDetails> userDetailsList = new ArrayList<>(Arrays.asList(
            new UserDetails(1, "Abhishek", "Sales Officer", 20014.20),
            new UserDetails(2, "Amit", "Software Engineer", 30000.20),
            new UserDetails(3, "Pranjal", "Software Engineer", 25000.20),
            new UserDetails(4, "Yash", "SalesForce Dev", 26714.20)));

    @Override
    public Response getAllDetails() {
        Response response = new Response();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage("Successfully Fetched All Data");
        response.setResult(userDetailsList);
        return response;
    }

    @Override
    public Response addUserData(UserDetails userDetails) {
        Response response = new Response();
        userDetailsList.add(userDetails);
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage("Successfully saved All Data");
        return response;
    }

    @Override
    public Response getById(int id) {
        Response response = new Response();
        UserDetails userDetails = userDetailsList.stream()
                .filter(s -> s.getId() == id).findAny().get();
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage("Success");
        response.setResult(userDetails);
        return response;
    }

    @Override
    public Response deleteById(int id) {
        Response response = new Response();
        UserDetails userDetails = userDetailsList.stream()
                .filter(s -> s.getId() == id).findAny().get();
        userDetailsList.remove(userDetails);
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage("Successfully Delete data at id "+id);
        return response;
    }

    @Override
    public Response updateData(int id, UserDetails userDetails) {
        Response response = new Response();
        UserDetails existingDetails = userDetailsList.stream()
                .filter(s -> s.getId() == id).findAny().get();
        if (existingDetails == null) {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setStatusMessage("Data not found at id " +id);
        }
        existingDetails.setDesignation(userDetails.getDesignation());
        existingDetails.setSalary(userDetails.getSalary());
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusMessage("Successfully update the data at id "+id);
        response.setResult(existingDetails);
        return response;
    }
}
