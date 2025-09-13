package com.enterprise.aiplatform.controller;

import com.enterprise.aiplatform.model.ChatConversation;
import com.enterprise.aiplatform.model.ChatMessage;
import com.enterprise.aiplatform.model.User;
import com.enterprise.aiplatform.service.ChatService;
import com.enterprise.aiplatform.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/conversations")
    public ResponseEntity<?> getConversations(@AuthenticationPrincipal User user) {
        List<ChatConversation> conversations = chatService.getConversationsByUser(user);
        List<ConversationResponse> response = conversations.stream()
                .map(ConversationResponse::fromConversation)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ApiResponse.success("获取对话列表成功", response));
    }

    @GetMapping("/conversations/{id}")
    public ResponseEntity<?> getConversation(@PathVariable Long id, @AuthenticationPrincipal User user) {
        ChatConversation conversation = chatService.getConversationById(id, user);
        return ResponseEntity.ok(ApiResponse.success("获取对话成功", ConversationDetailResponse.fromConversation(conversation)));
    }

    @PostMapping("/conversations")
    public ResponseEntity<?> createConversation(@RequestBody CreateConversationRequest request, @AuthenticationPrincipal User user) {
        ChatConversation conversation = chatService.createConversation(request.getTitle(), user);
        return ResponseEntity.ok(ApiResponse.success("创建对话成功", ConversationResponse.fromConversation(conversation)));
    }

    @PostMapping("/conversations/{id}/messages")
    public ResponseEntity<?> sendMessage(@PathVariable Long id, @RequestBody SendMessageRequest request, @AuthenticationPrincipal User user) {
        ChatMessage message = chatService.sendMessage(id, request.getContent(), user);
        ChatMessage response = chatService.generateResponse(id, user);
        
        return ResponseEntity.ok(ApiResponse.success("发送消息成功", MessageResponse.fromMessage(response)));
    }

    @DeleteMapping("/conversations/{id}")
    public ResponseEntity<?> deleteConversation(@PathVariable Long id, @AuthenticationPrincipal User user) {
        chatService.deleteConversation(id, user);
        return ResponseEntity.ok(ApiResponse.success("删除对话成功"));
    }

    // 请求和响应的内部类
    
    @lombok.Data
    public static class CreateConversationRequest {
        private String title;
    }
    
    @lombok.Data
    public static class SendMessageRequest {
        private String content;
    }
    
    @lombok.Data
    @lombok.Builder
    public static class ConversationResponse {
        private Long id;
        private String title;
        private String lastMessage;
        private String lastMessageTime;
        
        public static ConversationResponse fromConversation(ChatConversation conversation) {
            String lastMessage = "";
            String lastMessageTime = "";
            
            if (!conversation.getMessages().isEmpty()) {
                ChatMessage message = conversation.getMessages().get(conversation.getMessages().size() - 1);
                lastMessage = message.getContent();
                lastMessageTime = message.getCreatedAt().toString();
            }
            
            return ConversationResponse.builder()
                    .id(conversation.getId())
                    .title(conversation.getTitle())
                    .lastMessage(lastMessage)
                    .lastMessageTime(lastMessageTime)
                    .build();
        }
    }
    
    @lombok.Data
    @lombok.Builder
    public static class ConversationDetailResponse {
        private Long id;
        private String title;
        private List<MessageResponse> messages;
        
        public static ConversationDetailResponse fromConversation(ChatConversation conversation) {
            List<MessageResponse> messages = conversation.getMessages().stream()
                    .map(MessageResponse::fromMessage)
                    .collect(Collectors.toList());
            
            return ConversationDetailResponse.builder()
                    .id(conversation.getId())
                    .title(conversation.getTitle())
                    .messages(messages)
                    .build();
        }
    }
    
    @lombok.Data
    @lombok.Builder
    public static class MessageResponse {
        private Long id;
        private String role;
        private String content;
        private String createdAt;
        
        public static MessageResponse fromMessage(ChatMessage message) {
            return MessageResponse.builder()
                    .id(message.getId())
                    .role(message.getRole())
                    .content(message.getContent())
                    .createdAt(message.getCreatedAt().toString())
                    .build();
        }
    }
}