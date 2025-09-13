package com.enterprise.aiplatform.service;

import com.enterprise.aiplatform.model.ChatConversation;

public interface AIService {
    String generateResponse(ChatConversation conversation);
    String analyzeDocument(String documentContent);
    String summarizeText(String text);
    String translateText(String text, String targetLanguage);
}