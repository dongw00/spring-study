package com.example.springdb.config;

import com.example.springdb.repository.ItemRepository;
import com.example.springdb.repository.MemoryItemRepository;
import com.example.springdb.service.ItemService;
import com.example.springdb.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {

    @Bean
    public ItemService itemService() {
        return new ItemServiceV1(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository() {
        return new MemoryItemRepository();
    }

}
