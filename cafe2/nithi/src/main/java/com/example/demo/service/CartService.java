package com.example.demo.service;

import com.example.demo.model.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private List<Item> cartItems = new ArrayList<>();
    
    public void addToCart(Item item) {
        cartItems.add(item);
    }
    
    public List<Item> getCartItems() {
        return new ArrayList<>(cartItems);
    }
    
    public double getTotalAmount() {
        return cartItems.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
    
    public void clearCart() {
        cartItems.clear();
    }
    
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }
}