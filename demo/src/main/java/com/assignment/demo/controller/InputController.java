package com.assignment.demo.controller;

import com.assignment.demo.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("input")
public class InputController {
    @Autowired
    private InputService inputService;
    @GetMapping
    public ResponseEntity<String> getInput(@RequestParam String input){
        String res = inputService.handleInput(input);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
