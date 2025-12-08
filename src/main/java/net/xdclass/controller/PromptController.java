package net.xdclass.controller;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ai.chat.messages.Message;


import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("ai")
public class PromptController {
    
    @Autowired
    private ChatClient chatClient;

    // 添加USER角色和系统角色
    @GetMapping("prompt")
    public Map<String,Object> prompt(@RequestParam(value = "message", defaultValue = "你好") String message){

        List<Message> list = List.of(new SystemMessage("你是一个专业的导游"),new UserMessage(message));;
        Prompt prompt = new Prompt(list);
        String response = chatClient.prompt(prompt).user(message).call().content();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",response);
        map.put("code",200);
        return map;
    }

    // template
    @GetMapping("template")
    public Map<String,Object> template(@RequestParam(value = "message", defaultValue = "你好") String message){
        PromptTemplate promptTemplate = new PromptTemplate("你根据{theme}主题，创建一首诗。");
        Prompt prompt = promptTemplate.create(Map.of("theme", message));
        String response = chatClient.prompt(prompt).user(message).call().content();
        Map<String,Object> map = new HashMap<>();
        map.put("msg",response);
        map.put("code",200);
        return map;
    }
}
