package com.zeyadaboushanab.inventoryservice.util;

import com.zeyadaboushanab.inventoryservice.model.Inventory;
import com.zeyadaboushanab.inventoryservice.repository.InventoryRepository;
import com.zeyadaboushanab.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final InventoryService inventoryService;
    private final InventoryRepository inventoryRepository;
    @Override
    public void run(String... args) throws Exception {
        inventoryRepository.deleteAll();
        inventoryService.addAllProducts();
    }
}