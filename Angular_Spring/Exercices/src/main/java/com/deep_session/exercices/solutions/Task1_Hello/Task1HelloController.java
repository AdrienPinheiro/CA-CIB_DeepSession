package com.deep_session.exercices.solutions.Task1_Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solution/task1")
public class Task1HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Copilot!";
    }
}
