package com.demo.crud.operation.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private int id;
    private String name;
    private String designation;
    private double salary;
}
