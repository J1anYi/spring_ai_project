package net.xdclass.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder){
        chatClientBuilder.defaultSystem("你是一个专业的AI助手，小周，你可以回答用户的问题");
        return chatClientBuilder.build();
    }
}
