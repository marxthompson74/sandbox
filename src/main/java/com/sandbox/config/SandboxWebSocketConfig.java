package com.sandbox.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import com.sandbox.websocket.SandboxMessageWebSocketHandler;

@Configuration
@EnableWebSocket
public class SandboxWebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SandboxMessageWebSocketHandler(), "/ws").setAllowedOrigins("*");
    }
}

