package com.assignment.demo.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@Getter
public class InputRepo {
    List<String> inputList;
    InputRepo(){
        inputList = new ArrayList<>();
    }
}
