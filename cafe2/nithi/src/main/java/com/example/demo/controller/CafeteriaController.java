package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CafeteriaController {
    
    @Autowired
    private ItemRepository itemRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CartService cartService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "index";
    }
    
    @PostMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Optional<Item> itemOpt = itemRepository.findById(id);
        if (itemOpt.isPresent()) {
            cartService.addToCart(itemOpt.get());
            redirectAttributes.addFlashAttribute("message", "Item added to cart successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Item not found!");
        }
        return "redirect:/cart";
    }
    
    @GetMapping("/cart")
    public String cart(Model model) {
        List<Item> cartItems = cartService.getCartItems();
        double totalAmount = cartService.getTotalAmount();
        
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("isEmpty", cartService.isEmpty());
        
        return "cart";
    }
    
    @PostMapping("/place-order")
    public String placeOrder(RedirectAttributes redirectAttributes) {
        if (cartService.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Cart is empty!");
            return "redirect:/cart";
        }
        
        Order order = new Order();
        order.setItems(cartService.getCartItems());
        order.setTotalAmount(cartService.getTotalAmount());
        
        orderRepository.save(order);
        
        double totalAmount = cartService.getTotalAmount();
        cartService.clearCart();
        
        redirectAttributes.addFlashAttribute("totalAmount", totalAmount);
        redirectAttributes.addFlashAttribute("orderId", order.getId());
        
        return "redirect:/bill";
    }
    
    @GetMapping("/bill")
    public String bill() {
        return "bill";
    }
}