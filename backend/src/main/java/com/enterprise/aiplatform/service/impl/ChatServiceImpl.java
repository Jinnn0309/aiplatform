package com.enterprise.aiplatform.service.impl;

import com.enterprise.aiplatform.model.ChatConversation;
import com.enterprise.aiplatform.model.ChatMessage;
import com.enterprise.aiplatform.model.User;
import com.enterprise.aiplatform.repository.ChatConversationRepository;
import com.enterprise.aiplatform.repository.ChatMessageRepository;
import com.enterprise.aiplatform.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatConversationRepository conversationRepository;
    private final ChatMessageRepository messageRepository;
    private final AIService aiService;

    @Override
    public List<ChatConversation> getConversationsByUser(User user) {
        return conversationRepository.findByUserOrderByUpdatedAtDesc(user);
    }

    @Override
    public ChatConversation getConversationById(Long id, User user) {
        return conversationRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("对话不存在或无权访问"));
    }

    @Override
    @Transactional
    public ChatConversation createConversation(String title, User user) {
        ChatConversation conversation = ChatConversation.builder()
                .user(user)
                .title(title)
                .build();
        
        return conversationRepository.save(conversation);
    }

    @Override
    @Transactional
    public ChatMessage sendMessage(Long conversationId, String content, User user) {
        ChatConversation conversation = getConversationById(conversationId, user);
        
        ChatMessage message = ChatMessage.builder()
                .conversation(conversation)
                .role("user")
                .content(content)
                .build();
        
        conversation.setUpdatedAt(LocalDateTime.now());
        conversationRepository.save(conversation);
        
        return messageRepository.save(message);
    }

    @Override
    @Transactional
    public ChatMessage generateResponse(Long conversationId, User user) {
        ChatConversation conversation = getConversationById(conversationId, user);
        
        // 调用AI服务生成响应
        String responseContent = aiService.generateResponse(conversation);
        
        ChatMessage response = ChatMessage.builder()
                .conversation(conversation)
                .role("assistant")
                .content(responseContent)
                .build();
        
        conversation.setUpdatedAt(LocalDateTime.now());
        conversationRepository.save(conversation);
        
        return messageRepository.save(response);
    }

    @Override
    @Transactional
    public void deleteConversation(Long id, User user) {
        ChatConversation conversation = getConversationById(id, user);
        conversationRepository.delete(conversation);
    }
}