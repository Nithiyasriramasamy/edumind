package com.example.demo.config;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (itemRepository.count() == 0) {
            // Initialize sample food items
            
            itemRepository.save(new Item(null, "Burger", 320.00, "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Pizza", 520.00, "https://images.unsplash.com/photo-1565299624946-b28f40a0ca4b?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Sandwich", 280.00, "https://images.unsplash.com/photo-1553909489-cd47e0ef937f?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Pasta", 450.00, "https://images.unsplash.com/photo-1551183053-bf91a1d81141?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Salad", 320.00, "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Coffee", 160.00, "https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Fries", 200.00, "https://images.unsplash.com/photo-1576107232684-1279f390859f?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Soda", 120.00, "https://images.unsplash.com/photo-1581636625402-29b2a704ef13?w=300&h=200&fit=crop"));
            itemRepository.save(new Item(null, "Ice Cream", 250.00, "https://images.unsplash.com/photo-1563805042-7684c019e1cb?w=300&h=200&fit=crop"));
        }  
    }
}