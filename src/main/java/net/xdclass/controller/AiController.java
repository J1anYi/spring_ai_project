package net.xdclass.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ai")
public class AiController {

    @Autowired
    private OpenAiChatModel chatModel;

    @GetMapping("generate")
    public Map<String,Object> chat(String msg){
        String response = chatModel.call(msg);
        Map<String,Object> map = new HashMap<>();
        map.put("msg",response);
        map.put("code",200);
        return map;
    }
}
