package com.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.controller.model.OrderItem;



public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}
