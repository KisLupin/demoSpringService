package com.spring.Itemcatalogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ItemInitializer implements CommandLineRunner {

    private final ItemRepository ItemRepository;

    ItemInitializer(ItemRepository itemRepository) {
        this.ItemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok")
                .forEach(item -> ItemRepository.save(new Item(item)));

        ItemRepository.findAll().forEach(System.out::println);
    }
}
