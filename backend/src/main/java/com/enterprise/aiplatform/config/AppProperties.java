package com.enterprise.aiplatform.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private final Cors cors = new Cors();
    private final Upload upload = new Upload();
    private final Cache cache = new Cache();

    @Data
    public static class Cors {
        private String allowedOrigins;
        private String allowedMethods;
        private String allowedHeaders;
        private boolean allowCredentials;
    }

    @Data
    public static class Upload {
        private String maxFileSize;
        private String allowedTypes;
        private String storagePath;
    }

    @Data
    public static class Cache {
        private int defaultTtl;
    }
}