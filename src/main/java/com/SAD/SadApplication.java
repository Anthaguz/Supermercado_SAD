package com.SAD;

import com.SAD.service.FilesStorageService;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SadApplication {
    @Resource
    FilesStorageService storageService;
    public static void main(String[] args) {
        SpringApplication.run(SadApplication.class, args);
    }

    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }

}
