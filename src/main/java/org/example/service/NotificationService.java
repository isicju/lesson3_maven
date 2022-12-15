package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface NotificationService {
    void sendMessage(String recipient, String content) throws JsonProcessingException;
}
