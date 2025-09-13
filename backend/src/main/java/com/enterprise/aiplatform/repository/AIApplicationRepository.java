package com.enterprise.aiplatform.repository;

import com.enterprise.aiplatform.model.AIApplication;
import com.enterprise.aiplatform.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AIApplicationRepository extends JpaRepository<AIApplication, Long> {
    List<AIApplication> findByCategory(String category);
    List<AIApplication> findByFeatured(boolean featured);
    List<AIApplication> findByDepartmentsContaining(Department department);
    List<AIApplication> findByCategoryAndFeatured(String category, boolean featured);
    List<AIApplication> findByCategoryAndDepartmentsContaining(String category, Department department);
    List<AIApplication> findByFeaturedAndDepartmentsContaining(boolean featured, Department department);
    List<AIApplication> findByCategoryAndFeaturedAndDepartmentsContaining(String category, boolean featured, Department department);
    
    @Query("SELECT DISTINCT a.category FROM AIApplication a")
    List<String> findDistinctCategories();
    
    List<AIApplication> findTop5ByOrderByUpdatedAtDesc();
}