package com.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ecommerce.controller.model.OrderItem;
import com.ecommerce.repo.OrderItemRepository;


@Service
public class OrderItemServiceImplementation implements OrderItemService{

	private OrderItemRepository orderItemRepository;
	
	public OrderItemServiceImplementation(OrderItemRepository orderItemRepository) {
		this.orderItemRepository=orderItemRepository;	
	}
	
	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		
		return orderItemRepository.save(orderItem);
	}

}
