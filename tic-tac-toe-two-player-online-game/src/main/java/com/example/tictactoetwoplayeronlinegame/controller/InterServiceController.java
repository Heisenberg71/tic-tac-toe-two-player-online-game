package com.example.tictactoetwoplayeronlinegame.controller;

import com.example.tictactoetwoplayeronlinegame.dto.RequestDemo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class InterServiceController {
    @PostMapping("/receiverservice")
    public void interservice(@RequestBody RequestDemo requestDemo){
        System.out.println("I am here!" + requestDemo.requestDemoString);
    }
}
