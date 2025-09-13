package com.enterprise.aiplatform.repository;

import com.enterprise.aiplatform.model.ChatConversation;
import com.enterprise.aiplatform.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByConversationOrderByCreatedAtAsc(ChatConversation conversation);
    List<ChatMessage> findByConversationAndRoleOrderByCreatedAtAsc(ChatConversation conversation, String role);
    List<ChatMessage> findTop10ByConversationOrderByCreatedAtDesc(ChatConversation conversation);
}