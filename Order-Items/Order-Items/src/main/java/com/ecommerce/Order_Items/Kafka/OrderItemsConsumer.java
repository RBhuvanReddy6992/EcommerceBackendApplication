package com.ecommerce.Order_Items.Kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ecommerce.Order_Items.Service.OrderItemService;

@Service
public class OrderItemsConsumer {
	private final OrderItemService orderItemsService;

	public OrderItemsConsumer(OrderItemService orderItemsService) {
	    this.orderItemsService = orderItemsService;
	}

    @KafkaListener(topics = "order-topic", groupId = "order-items-group")
    public void consume(OrderEvent event) {

        System.out.println("Received Order: " + event.getOrderId());

        
        System.out.println("Saving items for product: " + event.getProductId());
    }
}
