package com.sandbox.websocket;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SandboxMessageWebSocketHandler extends TextWebSocketHandler {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedMessage = message.getPayload();
        System.out.println("Received via WebSocket: " + receivedMessage);

        // Call the REST API to get the message
        String apiMessage = restTemplate.getForObject("http://localhost:8080/api/message", String.class);

        // Send the message back to the WebSocket client
        session.sendMessage(new TextMessage("Server fetched: " + apiMessage));
    }
}


