package com.enterprise.aiplatform.service;

import com.enterprise.aiplatform.model.ChatConversation;
import com.enterprise.aiplatform.model.ChatMessage;
import com.enterprise.aiplatform.model.User;

import java.util.List;

public interface ChatService {
    List<ChatConversation> getConversationsByUser(User user);
    ChatConversation getConversationById(Long id, User user);
    ChatConversation createConversation(String title, User user);
    ChatMessage sendMessage(Long conversationId, String content, User user);
    ChatMessage generateResponse(Long conversationId, User user);
    void deleteConversation(Long id, User user);
}