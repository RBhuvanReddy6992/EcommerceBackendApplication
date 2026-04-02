package com.ecommerce.Order_Items.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Order_Items.Model.OrderItems;
import com.ecommerce.Order_Items.Service.OrderItemService;

@RestController
@RequestMapping("/order-items")
public class orderController {

    private final OrderItemService os;

    public orderController(OrderItemService os) {
        this.os = os;
    }

    // Create order item
    @PostMapping("/create")
    public ResponseEntity<OrderItems> createOrder(@RequestBody OrderItems oi) {
        return os.create(oi);
    }

    // Get order items by orderId
    @GetMapping("/order/{id}")
    public ResponseEntity<List<OrderItems>> getOrderById(@PathVariable int id) {
        return os.getItemsByOrderId(id);
    }

    // Delete order item by id
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderItems> deleteOrderById(@PathVariable int id) {
        return os.deleteById(id);
    }
}
