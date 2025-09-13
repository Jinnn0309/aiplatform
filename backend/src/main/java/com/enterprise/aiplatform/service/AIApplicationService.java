package com.enterprise.aiplatform.service;

import com.enterprise.aiplatform.model.AIApplication;

import java.util.List;

public interface AIApplicationService {
    List<AIApplication> findApplications(String category, Boolean featured, String department);
    AIApplication findById(Long id);
    List<String> findAllCategories();
    List<AIApplication> findRecentApplications();
    void recordUsage(Long id);
    AIApplication createApplication(AIApplication application);
    AIApplication updateApplication(Long id, AIApplication application);
    void deleteApplication(Long id);
    AIApplication updateApplicationStatus(Long id, boolean enabled);
}