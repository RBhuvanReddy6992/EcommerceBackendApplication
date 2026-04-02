package com.ecommerce.Category_Service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.Category_Service.Model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

	

}
