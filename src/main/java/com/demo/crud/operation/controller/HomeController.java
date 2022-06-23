package com.demo.crud.operation.controller;

import com.demo.crud.operation.beans.Response;
import com.demo.crud.operation.beans.UserDetails;
import com.demo.crud.operation.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amit Ojha
 */
@RestController
@RequestMapping("/demo-crud")
@Api(tags = "User-Controller", description = "User Controller")
public class HomeController {

    @Autowired
    private DataService dataService;

    /**
     * This will return as a list of all user data.
     *
     * @return UserDetails
     */
    @GetMapping("/all")
    @ApiOperation(value = "Get all user details")
    public ResponseEntity<Response> getAllUsersDetails() {
        return new ResponseEntity<>(dataService.getAllDetails(), HttpStatus.OK);
    }

    /**
     * This will return only one user data by id.
     *
     * @param id
     * @return UserDetails
     */
    @GetMapping("/id")
    @ApiOperation(value = "Get user details by id")
    public ResponseEntity<Response> getById(@RequestParam("Id") int id) {
        return new ResponseEntity<>(dataService.getById(id), HttpStatus.OK);
    }

    /**
     * This will add new user data into collection.
     *
     * @param userDetails
     * @return String
     */
    @PostMapping("/add")
    @ApiOperation(value = "Add user details")
    public ResponseEntity<Response> saveUserData(@RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(dataService.addUserData(userDetails), HttpStatus.OK);
    }

    /**
     * This method will delete the data by id.
     *
     * @param id
     * @return String
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete user details by id")
    public ResponseEntity<Response> deleteDataById(@RequestParam("Id") int id) {
        return new ResponseEntity<>(dataService.deleteById(id), HttpStatus.OK);
    }

    /**
     * This method will update the data by id.
     *
     * @param id
     * @param userDetails
     * @return UserDetails
     */
    @PutMapping("/update")
    @ApiOperation(value = "Update user details by id")
    public ResponseEntity<Response> updateDataById(@RequestParam("Id") int id, @RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(dataService.updateData(id, userDetails), HttpStatus.OK);
    }
}
