package com.SpringAI.TextConversion.service;

import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatClientService {

    @Autowired
    ChatModel chatModel;


   // private final ChatClient chatClient;


    /*public ChatClientService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }*/

    OpenAiChatModel.ResponseFormat responseFormat = OpenAiChatModel.ResponseFormat.builder()
            .type(OpenAiChatModel.ResponseFormat.Type.JSON_OBJECT)
            .build();

    public String chat(String message){

        List<Message> messages = List.of(
                new SystemMessage("You are a tutor. Reply in JSON format"),
                new UserMessage(message)
        );

        ChatOptions chatOptions = OpenAiChatOptions.builder()
                .model("gpt-4o-mini")
                .responseFormat(responseFormat)
                .temperature(0.5)
                .maxTokens(100)
                .build();

        Prompt prompt = Prompt.builder()
                .messages(messages)
                .chatOptions(chatOptions)
                .build();

        ChatResponse response = chatModel.call(prompt);

        return response.getResult().getOutput().getText();


    }
}
