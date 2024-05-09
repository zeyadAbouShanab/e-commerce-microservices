package com.zeyadaboushanab.productservice.util;

import com.zeyadaboushanab.productservice.model.Product;
import com.zeyadaboushanab.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        List<Product> products = initializeProducts();
        productRepository.saveAll(products);
        log.info("Product DataLoader started");

    }

    private static List<Product> initializeProducts(){
        List<Product> products = new ArrayList<>();
        Product product1 = Product.builder()
                .name("Wireless Bluetooth Earbuds")
                .description("Experience true wireless freedom with these Bluetooth earbuds. Enjoy crystal-clear sound and ergonomic design.")
                .price(BigDecimal.valueOf(49.99))
                .build();

        Product product2 = Product.builder()
                .name("Smart LED TV")
                .description("Transform your living room with this smart LED TV. Enjoy stunning visuals and access to a world of entertainment.")
                .price(BigDecimal.valueOf(699.99))
                .build();

        Product product3 = Product.builder()
                .name("Portable Power Bank")
                .description("Stay charged on the go with this portable power bank. Compact and lightweight, it's perfect for travel.")
                .price(BigDecimal.valueOf(29.99))
                .build();

        Product product4 = Product.builder()
                .name("Gaming Laptop")
                .description("Unleash your gaming potential with this high-performance gaming laptop. Dominate the competition with its powerful specs.")
                .price(BigDecimal.valueOf(1499.99))
                .build();

        Product product5 = Product.builder()
                .name("Smart Home Security Camera")
                .description("Keep your home safe and secure with this smart security camera. Monitor your property from anywhere with ease.")
                .price(BigDecimal.valueOf(89.99))
                .build();

        Product product6 = Product.builder()
                .name("Wireless Charging Pad")
                .description("Say goodbye to tangled cables with this wireless charging pad. Charge your devices effortlessly and in style.")
                .price(BigDecimal.valueOf(19.99))
                .build();

        Product product7 = Product.builder()
                .name("Bluetooth Speaker")
                .description("Enjoy powerful sound wherever you go with this Bluetooth speaker. Portable and durable, it's perfect for outdoor adventures.")
                .price(BigDecimal.valueOf(59.99))
                .build();

        Product product8 = Product.builder()
                .name("Smartwatch")
                .description("Stay connected and organized with this sleek smartwatch. Track your fitness goals and receive notifications on the go.")
                .price(BigDecimal.valueOf(129.99))
                .build();

        Product product9 = Product.builder()
                .name("Wireless Headphones")
                .description("Immerse yourself in music with these wireless headphones. Experience premium sound quality and all-day comfort.")
                .price(BigDecimal.valueOf(99.99))
                .build();

        Product product10 = Product.builder()
                .name("Compact Digital Camera")
                .description("Capture life's precious moments with this compact digital camera. Easy to use and packed with features.")
                .price(BigDecimal.valueOf(279.99))
                .build();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);
        return products;
    }
}
