package com.example.springdb;

import com.example.springdb.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Import(JdbcTemplateV1Config.class)
@SpringBootApplication(scanBasePackages = "com.example.springdb.controller")
public class SpringDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDbApplication.class, args);
    }

    @Bean
    @Profile("local")
    public TestDataInit testDataInit(ItemRepository itemRepository) {
        return new TestDataInit(itemRepository);
    }

}
