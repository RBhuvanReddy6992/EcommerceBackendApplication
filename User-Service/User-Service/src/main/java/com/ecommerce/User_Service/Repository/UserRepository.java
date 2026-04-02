package com.ecommerce.User_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.User_Service.Model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
