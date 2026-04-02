package com.ecommerce.Product_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.Product_Service.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	

}
