package com.enterprise.aiplatform.repository;

import com.enterprise.aiplatform.model.ChatConversation;
import com.enterprise.aiplatform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatConversationRepository extends JpaRepository<ChatConversation, Long> {
    List<ChatConversation> findByUserOrderByUpdatedAtDesc(User user);
    List<ChatConversation> findByUserAndTitleContainingIgnoreCaseOrderByUpdatedAtDesc(User user, String title);
    List<ChatConversation> findByUserAndMessagesIsNotEmptyOrderByUpdatedAtDesc(User user);
    List<ChatConversation> findByUserAndTitleContainingIgnoreCaseAndMessagesIsNotEmptyOrderByUpdatedAtDesc(User user, String title);
}