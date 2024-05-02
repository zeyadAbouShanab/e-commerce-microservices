package com.zeyadaboushanab.inventoryservice.util;

import com.zeyadaboushanab.inventoryservice.model.Inventory;
import com.zeyadaboushanab.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final InventoryRepository inventoryRepository;
    @Override
    public void run(String... args) throws Exception {
        Inventory inventory = new Inventory();
        inventory.setSkuCode("product1");
        inventory.setQuantity(100);

        Inventory inventory1 = new Inventory();
        inventory1.setSkuCode("product2");
        inventory1.setQuantity(50);

        inventoryRepository.save(inventory);
        inventoryRepository.save(inventory1);
    }
}