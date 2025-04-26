package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AgentController {

    @Autowired
    private AgentService agentService;

//    @PostMapping("/create-agent")
    @PostMapping("/create-agent")
    public ResponseEntity<String> createAgent(@RequestBody AgentRequest request) {
        return agentService.createAgent(request.getPlatform(), request.getAgentData());
    }
}
