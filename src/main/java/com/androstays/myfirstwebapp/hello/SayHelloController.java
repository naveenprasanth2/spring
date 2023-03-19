package com.androstays.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello What are you learning today";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuilder sb  = new StringBuilder();
        sb.append("<html>").append("<head>").append("<title>")
                .append("My first HTML page").append("</title>")
                .append("<body>").append("My first HTML body changed")
                .append("</body>").append("</html>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}
