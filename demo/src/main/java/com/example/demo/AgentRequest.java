package com.example.demo;

import java.util.Map;

public class AgentRequest {

        private String platform;
        private Map<String, Object> agentData;

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public Map<String, Object> getAgentData() {
            return agentData;
        }

        public void setAgentData(Map<String, Object> agentData) {
            this.agentData = agentData;
        }
    }


