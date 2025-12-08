// package net.xdclass.controller;

// import org.springframework.ai.chat.client.ChatClient;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("chat")
// public class ChatClientController {
    
//     private final ChatClient chatClient;

//     public ChatClientController(ChatClient.Builder chatClientBuilder) {
//         this.chatClient = chatClientBuilder.build();
//     }

//     @GetMapping("generate")
//     public Map<String,Object> chat(String msg){
//         String response = chatClient.prompt().user(msg).call().content();
//         Map<String,Object> map = new HashMap<>();
//         map.put("msg",response);
//         map.put("code",200);
//         return map;
//     }
// }
