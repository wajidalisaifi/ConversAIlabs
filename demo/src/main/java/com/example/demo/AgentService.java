package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgentService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<String> createAgent(String platform, Object agentData) {
        String url;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if ("vapi".equalsIgnoreCase(platform)) {
            url = "https://api.vapi.ai/v1/assistants";
            headers.set("Authorization", "Bearer YOUR_VAPI_API_KEY");
        } else if ("retell".equalsIgnoreCase(platform)) {
            url = "https://api.retellai.com/agents";
            headers.set("Authorization", "Bearer YOUR_RETELL_API_KEY");
        } else {
            return ResponseEntity.badRequest().body("Invalid platform");
        }

        HttpEntity<Object> request = new HttpEntity<>(agentData, headers);

        try {
            return restTemplate.postForEntity(url, request, String.class);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

}
