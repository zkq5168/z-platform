package com.zkq.platform.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class CodeGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeGeneratorApplication.class, args);
    }
}
