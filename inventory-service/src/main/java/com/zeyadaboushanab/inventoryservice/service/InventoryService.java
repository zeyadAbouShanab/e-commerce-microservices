package com.zeyadaboushanab.inventoryservice.service;

import com.zeyadaboushanab.inventoryservice.dto.InventoryResponse;
import com.zeyadaboushanab.inventoryservice.dto.Product;
import com.zeyadaboushanab.inventoryservice.model.Inventory;
import com.zeyadaboushanab.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final WebClient.Builder webClientBuilder;


    @Transactional(readOnly = true)
    @SneakyThrows
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        log.info("Checking Inventory");

        // Fetch inventory records for the given skuCodes
        List<Inventory> inventoryList = inventoryRepository.findBySkuCodeIn(skuCodes);

        // Create a map to store skuCode -> isInStock mapping for found inventory records
        Map<String, Boolean> isInStockMap = new HashMap<>();
        inventoryList.forEach(inventory -> isInStockMap.put(inventory.getSkuCode(), inventory.getQuantity() > 0));

        // Create InventoryResponse objects for each skuCode, setting isInStock to false if no corresponding inventory record is found
        return skuCodes.stream()
                .map(skuCode ->
                        InventoryResponse.builder()
                                .skuCode(skuCode)
                                .isInStock(isInStockMap.getOrDefault(skuCode, false))
                                .build()
                ).toList();
    }


    public List<Product> getAllProducts(){

        Product[] products = webClientBuilder.build().get()
                .uri("http://product-service/api/product",
                        UriBuilder::build)
                .retrieve()
                .bodyToMono(Product[].class)
                .block();
        if(products == null){
            return new ArrayList<>();
        }
        return Arrays.asList(products);
    }

    public void addAllProducts(){
        getAllProducts().forEach(
                product -> {
                    Inventory inventory = new Inventory();
                    inventory.setSkuCode(product.getSkuCode());
                    inventory.setQuantity(new Random().nextInt(500 + 1 - 50) + 50);
                    inventoryRepository.save(inventory);
        });
    }
}