package com.enterprise.aiplatform.service.impl;

import com.enterprise.aiplatform.model.AIApplication;
import com.enterprise.aiplatform.model.Department;
import com.enterprise.aiplatform.repository.AIApplicationRepository;
import com.enterprise.aiplatform.repository.DepartmentRepository;
import com.enterprise.aiplatform.service.AIApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AIApplicationServiceImpl implements AIApplicationService {

    private final AIApplicationRepository applicationRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    @Cacheable(value = "applications", key = "#category + '-' + #featured + '-' + #department")
    public List<AIApplication> findApplications(String category, Boolean featured, String department) {
        if (category != null && featured != null && department != null) {
            Department dept = departmentRepository.findByName(department)
                    .orElseThrow(() -> new RuntimeException("部门不存在"));
            return applicationRepository.findByCategoryAndFeaturedAndDepartmentsContaining(category, featured, dept);
        } else if (category != null && featured != null) {
            return applicationRepository.findByCategoryAndFeatured(category, featured);
        } else if (category != null && department != null) {
            Department dept = departmentRepository.findByName(department)
                    .orElseThrow(() -> new RuntimeException("部门不存在"));
            return applicationRepository.findByCategoryAndDepartmentsContaining(category, dept);
        } else if (featured != null && department != null) {
            Department dept = departmentRepository.findByName(department)
                    .orElseThrow(() -> new RuntimeException("部门不存在"));
            return applicationRepository.findByFeaturedAndDepartmentsContaining(featured, dept);
        } else if (category != null) {
            return applicationRepository.findByCategory(category);
        } else if (featured != null) {
            return applicationRepository.findByFeatured(featured);
        } else if (department != null) {
            Department dept = departmentRepository.findByName(department)
                    .orElseThrow(() -> new RuntimeException("部门不存在"));
            return applicationRepository.findByDepartmentsContaining(dept);
        } else {
            return applicationRepository.findAll();
        }
    }

    @Override
    @Cacheable(value = "application", key = "#id")
    public AIApplication findById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("应用不存在"));
    }

    @Override
    @Cacheable(value = "categories")
    public List<String> findAllCategories() {
        return applicationRepository.findDistinctCategories();
    }

    @Override
    public List<AIApplication> findRecentApplications() {
        // 这里应该根据用户的使用记录来获取最近使用的应用
        // 简化实现，返回所有应用
        return applicationRepository.findTop5ByOrderByUpdatedAtDesc();
    }

    @Override
    @Transactional
    public void recordUsage(Long id) {
        // 记录应用使用情况的逻辑
        // 简化实现，只检查应用是否存在
        findById(id);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"applications", "application", "categories"}, allEntries = true)
    public AIApplication createApplication(AIApplication application) {
        return applicationRepository.save(application);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"applications", "application", "categories"}, allEntries = true)
    public AIApplication updateApplication(Long id, AIApplication application) {
        AIApplication existing = findById(id);
        
        existing.setName(application.getName());
        existing.setDescription(application.getDescription());
        existing.setIcon(application.getIcon());
        existing.setCategory(application.getCategory());
        existing.setVersion(application.getVersion());
        existing.setApiEndpoint(application.getApiEndpoint());
        existing.setDocumentationUrl(application.getDocumentationUrl());
        existing.setEnabled(application.isEnabled());
        existing.setFeatured(application.isFeatured());
        existing.setDepartments(application.getDepartments());
        
        return applicationRepository.save(existing);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"applications", "application", "categories"}, allEntries = true)
    public void deleteApplication(Long id) {
        AIApplication application = findById(id);
        applicationRepository.delete(application);
    }

    @Override
    @Transactional
    @CacheEvict(value = {"applications", "application"}, key = "#id")
    public AIApplication updateApplicationStatus(Long id, boolean enabled) {
        AIApplication application = findById(id);
        application.setEnabled(enabled);
        return applicationRepository.save(application);
    }
}