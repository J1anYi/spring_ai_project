package net.xdclass.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
    
    @Bean
    public ChatClient chatClient(OpenAiChatModel chatModel, ChatMemory chatMemory){
        ChatClient.Builder chatClientBuilder = ChatClient.builder(chatModel);
        chatClientBuilder.defaultSystem("你是一个专业的AI助手，小周，你可以回答用户的问题");
        chatClientBuilder.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build(), new SimpleLoggerAdvisor());  
        return chatClientBuilder.build();
    }
}
