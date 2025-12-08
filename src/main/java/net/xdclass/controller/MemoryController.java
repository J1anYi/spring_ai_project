package net.xdclass.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("ai")
public class MemoryController {

    @Autowired
    private ChatClient chatClient;
    
    @RequestMapping("memory")
    public String chat(@RequestParam("msg") String msg, @RequestParam("conversationId") String conversationId){
        return this.chatClient.prompt().user(msg).advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId)).call().content();
    }
}
