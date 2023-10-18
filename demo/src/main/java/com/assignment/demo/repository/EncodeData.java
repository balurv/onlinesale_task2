package com.assignment.demo.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Getter
public class EncodeData {
    private Map<Character, String> mapData;
    EncodeData(){
        mapData = new HashMap<>();
        insertData();
    }
    private void insertData(){
        mapData.put('(',"%28");
        mapData.put(')',"%29");
        mapData.put('*',"%2A");
        mapData.put('+',"%2B");
        mapData.put('-',"%2D");
        mapData.put('/',"%2F");
        mapData.put('^',"%5E");
        mapData.put(' ',"%20");
    }
}

