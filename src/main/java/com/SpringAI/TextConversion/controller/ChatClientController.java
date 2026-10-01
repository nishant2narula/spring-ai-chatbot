package com.SpringAI.TextConversion.controller;

import com.SpringAI.TextConversion.service.ChatClientService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class ChatClientController {

    @Autowired
   ChatClientService chatClientService;



    @GetMapping("/chat")
    public String chat(@RequestParam String prompt) {
            return chatClientService.chat(prompt);
    }

}
