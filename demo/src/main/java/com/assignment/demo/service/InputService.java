package com.assignment.demo.service;

import com.assignment.demo.entity.SimplifyResponse;
import com.assignment.demo.repository.EncodeData;
import com.assignment.demo.repository.InputRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class InputService {
    @Autowired
    private InputRepo inputRepo;
    @Autowired
    private EncodeData encodeData;
    public String handleInput(String input){
        input = input.trim();
        if(input.equals("end")){
            StringBuilder sb = new StringBuilder();
            for(String s: inputRepo.getInputList()){
                StringBuilder encode = solve(s);
                try{
                    SimplifyResponse simplifyResponse = (SimplifyResponse) callApi(encode.toString());
                    sb.append(s+" => "+simplifyResponse.getResult()+ "\n");
                }
                catch (Exception e){
                    e.printStackTrace();
                    sb.append(s+" => Result unkown! :( \n");
                }

            }
            inputRepo.getInputList().clear();
            return sb.toString();
        }
        inputRepo.getInputList().add(input);
        return input;
    }

    private StringBuilder solve(String input){
        StringBuilder qurey = new StringBuilder();
        for(int i = 0 ; i < input.length(); i++){
            char ch = input.charAt(i);
            if( encodeData.getMapData().get(ch) != null){
                qurey.append(encodeData.getMapData().get(ch));
                continue;
            }
            qurey.append(ch);
        }
        return qurey;
    }

    private Object callApi(String query){
        try {
            //using 3rd party api
            String apiUrl = "https://newton.vercel.app/api/v2/simplify/"+query;
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            conn.setRequestMethod("GET");

            // Get the response code
            int responseCode = conn.getResponseCode();
            System.out.println("Sending GET request to: " + apiUrl);
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the API
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Create a SimplifyResponse object from the JSON data
                SimplifyResponse simplifyResponse = new SimplifyResponse();
                simplifyResponse.setOperation(jsonResponse.getString("operation"));
                simplifyResponse.setExpression(jsonResponse.getString("expression"));
                simplifyResponse.setResult(jsonResponse.getString("result"));

                return simplifyResponse;
//                return response.toString();
            }
            else {
                return "Failed Get Request.";
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
