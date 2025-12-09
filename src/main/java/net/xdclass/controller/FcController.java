package net.xdclass.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ai")
public class FcController {
    @Autowired
    private ChatClient chatClient;

    @RequestMapping("fc")
    public String fc(@RequestParam("msg") String msg){
        return chatClient.prompt().user(msg).tools(new GetDateTimeTools(), new GetWeatherTools()).call().content();
    }

    public class GetDateTimeTools {
        @Tool(description = "获取当前日期时间")
        String getCurrentDateTime(){
            System.out.println("获取当前日期时间");
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    public class GetWeatherTools {
        // 获得天气工具，输入当前时间，返回当前时间的天气
        @Tool(description = "获取当前时间的天气")
        String getCurrentWeather(@ToolParam(description = "当前日期时间, 格式为YYYY-MM-dd或者今天，明天格式") String currentDateTime){
            System.out.println("获取当前时间的天气");
            return "当前时间是：" + currentDateTime + "，天气是：晴";
        }
    }
}
