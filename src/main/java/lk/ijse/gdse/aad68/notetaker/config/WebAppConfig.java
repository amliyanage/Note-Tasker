package lk.ijse.gdse.aad68.notetaker.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.aad68.notetaker")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "lk.ijse.gdse.aad68.notetaker")
@EnableTransactionManagement
@MultipartConfig  ( // enable multipart form data handling..
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class WebAppConfig {
}
