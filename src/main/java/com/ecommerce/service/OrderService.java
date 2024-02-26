package com.ecommerce.service;

import java.util.List;

import com.ecommerce.controller.model.Address;
import com.ecommerce.controller.model.Order;
import com.ecommerce.controller.model.User;
import com.ecommerce.exception.OrderException;



public interface OrderService{
	
	public Order createOrder(User user, Address shippingAddress);
	
	public Order findOrderById(Long orderId) throws OrderException;
	
	public Order placedOrder(Long orderId) throws OrderException;
	
	public Order confirmedOrder(Long orderId) throws OrderException;
	
	public Order shippedOrder(Long orderId) throws OrderException;
	
	public List<Order> userOrderHistory(Long orderId) throws OrderException;
	
	public Order deliveredOrder(Long orderId) throws OrderException;
	
	public Order cancledOrder(Long orderId) throws OrderException;
	
	public List<Order> getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;
	
	
	
	

	
}
