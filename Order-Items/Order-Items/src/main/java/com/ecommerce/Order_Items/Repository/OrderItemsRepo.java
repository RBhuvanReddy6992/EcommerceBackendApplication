package com.ecommerce.Order_Items.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Order_Items.Model.OrderItems;

public interface OrderItemsRepo extends JpaRepository<OrderItems,Integer> {

	List<OrderItems> findByOrderId(Integer id);

} 
