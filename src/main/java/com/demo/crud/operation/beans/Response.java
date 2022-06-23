package com.demo.crud.operation.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private int statusCode;
    private String statusMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object result;
}
