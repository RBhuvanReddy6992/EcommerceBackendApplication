package com.ecommerce.Order_Servcie.Kafka;


import org.springframework.kafka.core.KafkaTemplate; 
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        System.out.print("OrderProducer +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

    public void sendOrderEvent(OrderEvent event) {
        kafkaTemplate.send("order-topic", event);
    }
}
