package com.ecommerce.service;

import com.ecommerce.controller.model.Cart;
import com.ecommerce.controller.model.User;
import com.ecommerce.exception.ProductException;
import com.ecommerce.request.AddItemRequest;

public interface CartService {
	
	public Cart creatCart(User user);
	
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
	
	public Cart findUserCart(Long userId);

}
