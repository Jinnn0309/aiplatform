package com.enterprise.aiplatform.controller;

import com.enterprise.aiplatform.model.AIApplication;
import com.enterprise.aiplatform.service.AIApplicationService;
import com.enterprise.aiplatform.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class AIApplicationController {

    private final AIApplicationService applicationService;

    @GetMapping
    public ResponseEntity<?> getAllApplications(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean featured,
            @RequestParam(required = false) String department) {
        
        List<AIApplication> applications = applicationService.findApplications(category, featured, department);
        return ResponseEntity.ok(ApiResponse.success("获取应用列表成功", applications));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicationById(@PathVariable Long id) {
        AIApplication application = applicationService.findById(id);
        return ResponseEntity.ok(ApiResponse.success("获取应用详情成功", application));
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories() {
        List<String> categories = applicationService.findAllCategories();
        return ResponseEntity.ok(ApiResponse.success("获取分类列表成功", categories));
    }

    @GetMapping("/recent")
    public ResponseEntity<?> getRecentApplications() {
        List<AIApplication> applications = applicationService.findRecentApplications();
        return ResponseEntity.ok(ApiResponse.success("获取最近使用应用成功", applications));
    }

    @PostMapping("/{id}/usage")
    public ResponseEntity<?> recordApplicationUsage(@PathVariable Long id) {
        applicationService.recordUsage(id);
        return ResponseEntity.ok(ApiResponse.success("记录应用使用成功"));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createApplication(@RequestBody AIApplication application) {
        AIApplication created = applicationService.createApplication(application);
        return ResponseEntity.ok(ApiResponse.success("创建应用成功", created));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateApplication(@PathVariable Long id, @RequestBody AIApplication application) {
        AIApplication updated = applicationService.updateApplication(id, application);
        return ResponseEntity.ok(ApiResponse.success("更新应用成功", updated));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok(ApiResponse.success("删除应用成功"));
    }

    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateApplicationStatus(@PathVariable Long id, @RequestBody Map<String, Boolean> status) {
        Boolean enabled = status.get("enabled");
        if (enabled == null) {
            return ResponseEntity.badRequest().body(ApiResponse.error("状态参数不能为空"));
        }
        
        AIApplication updated = applicationService.updateApplicationStatus(id, enabled);
        return ResponseEntity.ok(ApiResponse.success("更新应用状态成功", updated));
    }
}