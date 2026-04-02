package com.ecommerce.Cart_Service.Kafka;



import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ecommerce.Cart_Service.Service.CartService;

@Service
public class OrderConsumer {
	
	private final CartService cartService;

	public OrderConsumer(CartService cartService) {
	    this.cartService = cartService;
	}

	@KafkaListener(topics = "order-topic", groupId = "cart-group")
	public void consume(OrderEvent event) {

	    System.out.println("Order Received: " + event.getOrderId());

	    cartService.clearCart(event.getUserId()); 
	}
}