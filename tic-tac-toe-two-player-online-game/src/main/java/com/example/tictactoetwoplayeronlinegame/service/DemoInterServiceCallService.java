package com.example.tictactoetwoplayeronlinegame.service;

import com.example.tictactoetwoplayeronlinegame.dto.RequestDemo;
import com.example.tictactoetwoplayeronlinegame.dto.ResponseDemo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class DemoInterServiceCallService {
    RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/demo")
    public ResponseDemo demoInterService(@RequestBody RequestDemo requestDemo){
        String url = "http://localhost:8080/api/receiverservice";

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("headername", "headervalue");
//        HttpEntity<RequestDemo> request = new HttpEntity<>(requestDemo, headers);

        ResponseDemo responseDemo = restTemplate.postForObject(url, requestDemo, ResponseDemo.class);
        return responseDemo;
    }
}
