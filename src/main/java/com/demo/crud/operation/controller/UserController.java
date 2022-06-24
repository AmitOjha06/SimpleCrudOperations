package com.demo.crud.operation.controller;

import com.demo.crud.operation.beans.Response;
import com.demo.crud.operation.beans.UserDetails;
import com.demo.crud.operation.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Amit Ojha
 */
@RestController
@RequestMapping("/demo-crud/user")
@Api(tags = "User-Controller", description = "User Controller")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This will return as a list of all user data.
     *
     * @return UserDetails
     */
    @GetMapping("/all")
    @ApiOperation(value = "Get all user details")
    public ResponseEntity<Response> getAllUsersDetails() {
        return new ResponseEntity<>(userService.getAllDetails(), HttpStatus.OK);
    }

    /**
     * This will return only one user data by id.
     *
     * @param id
     * @return UserDetails
     */
    @GetMapping("/id")
    @ApiOperation(value = "Get user details by id")
    public ResponseEntity<Response> getById(@ApiParam(name = "Id", defaultValue = "1") @RequestParam("Id") int id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    /**
     * This will add new user data into collection.
     *
     * @param userDetails
     * @return  Success Message
     */
    @PostMapping("/add")
    @ApiOperation(value = "Add user details")
    public ResponseEntity<Response> saveUserData(@RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(userService.addUserData(userDetails), HttpStatus.OK);
    }

    /**
     * This method will delete the data by id.
     *
     * @param id
     * @return Success message for delete data
     */
    @DeleteMapping("/delete/id")
    @ApiOperation(value = "Delete user details by id")
    public ResponseEntity<Response> deleteDataById(@ApiParam(name = "Id") @RequestParam("Id") int id) {
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

    /**
     * This method will update the data by id.
     *
     * @param id
     * @param userDetails
     * @return UserDetails
     */
    @PutMapping("/update/id")
    @ApiOperation(value = "Update user details by id")
    public ResponseEntity<Response> updateDataById(@ApiParam(name = "Id") @RequestParam("Id") int id, @RequestBody UserDetails userDetails) {
        return new ResponseEntity<>(userService.updateData(id, userDetails), HttpStatus.OK);
    }
}
