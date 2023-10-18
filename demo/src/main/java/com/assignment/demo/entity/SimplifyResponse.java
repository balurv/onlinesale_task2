package com.assignment.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifyResponse {
    private String operation;
    private String expression;
    private String result;
}
