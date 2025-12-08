package net.xdclass.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("ai")
public class DefaultChatClientController {
    
    @Autowired
    private ChatClient chatClient;

    @GetMapping("default_client")
    public Map<String,Object> chat(String message){
        String response = chatClient.prompt().user(message).call().content();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",response);
        map.put("code",200);
        return map;
    }

    // 流式响应
    @GetMapping(value = "stream",produces = "text/html;charset=UTF-8")
    public Flux<String> chatStream(@RequestParam(value = "message", defaultValue = "你好") String message){
        return chatClient.prompt().user(message).stream().content();
    }
}
