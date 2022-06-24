package com.demo.crud.operation.service;

import com.demo.crud.operation.beans.Response;
import com.demo.crud.operation.beans.UserDetails;

public interface UserService {
    Response getAllDetails();

    Response addUserData(UserDetails userDetails);

    Response getById(int id);

    Response deleteById(int id);

    Response updateData(int id, UserDetails userDetails);
}
