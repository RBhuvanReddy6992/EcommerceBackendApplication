package com.ecommerce.Order_Servcie.Controller;
import java.util.List; 

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.Order_Servcie.Model.Orders;
import com.ecommerce.Order_Servcie.Service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService oc;

    public OrdersController(OrdersService oc) {
        this.oc = oc;
        System.out.print("Order controller ----------------------------------------------------------------------------------------------------------------------");
    }

    
    @GetMapping
    public List<Orders> getAllOrders() {
        return oc.getAllOrders();
        
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getById(@PathVariable int id) {
        return oc.getById(id);
    }

    
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Orders>> getOrdersByuserId(@PathVariable int id) {
        return ResponseEntity.ok(oc.getByUserId(id));
    }
}
