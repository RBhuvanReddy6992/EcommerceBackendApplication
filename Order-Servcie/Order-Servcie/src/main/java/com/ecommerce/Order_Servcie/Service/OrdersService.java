package com.ecommerce.Order_Servcie.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.Order_Servcie.Kafka.OrderEvent;
import com.ecommerce.Order_Servcie.Kafka.OrderProducer;
import com.ecommerce.Order_Servcie.Model.Orders;
import com.ecommerce.Order_Servcie.Model.ProductDto;
import com.ecommerce.Order_Servcie.Repository.OrdersRepository;
import com.ecommerce.Order_Service.feign.ProductClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrdersService {

	private final OrdersRepository ordersRepository;
	private final ProductClient productclient;
	private final OrderProducer orderProducer;

	public OrdersService(OrdersRepository ordersRepository, ProductClient productclient, OrderProducer orderProducer) {
		this.ordersRepository = ordersRepository;
		this.productclient = productclient;

		this.orderProducer = orderProducer;
		System.out.print("Orderservice");
	}
	
	
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	public ResponseEntity<Orders> getById(int id) {
		return ordersRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	public List<Orders> getByUserId(int userId) {
		return ordersRepository.findByUserid(userId);
	}

	public Orders createOrder(Orders order) {

		ProductDto product = getProduct(order.getProductId());

		if (product.getStock() <= 0) {
			throw new RuntimeException("Product out of stock");
		}

		Orders savedOrder = ordersRepository.save(order);

		OrderEvent event = new OrderEvent();
		event.setOrderId(savedOrder.getOrder_id());
		event.setUserId(savedOrder.getUserid());
		event.setProductId(savedOrder.getProductId());

		orderProducer.sendOrderEvent(event);

		return savedOrder;
	}

	@CircuitBreaker(name = "productService", fallbackMethod = "fallbackProduct")
	public ProductDto getProduct(Integer productId) {
		return productclient.getProduct(productId);
	}

	public ProductDto fallbackProduct(Integer productId, Exception ex) {

		ProductDto dto = new ProductDto();
		dto.setId(productId);
		dto.setName("Fallback Product");
		dto.setPrice(0.0);
		dto.setStock(0);

		return dto;
	}
}