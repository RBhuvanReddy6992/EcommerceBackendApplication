package com.ecommerce.Cart_Service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Cart_Service.Model.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer>{

	Cart findByUseridAndProductid(Integer userid, Integer productid);

	List<Cart> findByUserid(Integer userId);

}
