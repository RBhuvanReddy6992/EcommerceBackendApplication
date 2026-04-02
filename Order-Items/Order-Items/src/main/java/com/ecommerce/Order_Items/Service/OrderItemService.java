package com.ecommerce.Order_Items.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.Order_Items.Kafka.OrderEvent;
import com.ecommerce.Order_Items.Model.OrderItems;
import com.ecommerce.Order_Items.Repository.OrderItemsRepo;

@Service
public class OrderItemService {
	
	private final OrderItemsRepo repo;
	public OrderItemService(OrderItemsRepo repo) {
		this.repo=repo;
	}
	 public ResponseEntity<OrderItems> create(OrderItems item) {
	        return ResponseEntity.ok(repo.save(item));
	    }
	 public ResponseEntity<List<OrderItems>> getItemsByOrderId(int orderId) {
		    List<OrderItems> items = repo.findByOrderId(orderId);

		    if (items.isEmpty()) {
		        return ResponseEntity.notFound().build();
		    }

		    return ResponseEntity.ok(items);
		}
	 public void saveOrderItems(OrderEvent event) {

		 System.out.println("Saving order items in DB...");

	       
	        OrderItems item = new OrderItems();
	        item.setOrderId(event.getOrderId());
	        item.setProduct_id(event.getProductId());
	        item.setUserId(event.getUserId());

	        
	        repo.save(item);

	        System.out.println("Order Item Saved Successfully");
	    }
		

	public ResponseEntity<OrderItems> deleteById(int id) {
		if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
	}
	
}
