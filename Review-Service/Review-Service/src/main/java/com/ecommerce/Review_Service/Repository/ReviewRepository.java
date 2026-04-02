package com.ecommerce.Review_Service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Review_Service.Model.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer> {

	List<Review> findByProductId(int id);

	List<Review> findByUserId(int id);

}
