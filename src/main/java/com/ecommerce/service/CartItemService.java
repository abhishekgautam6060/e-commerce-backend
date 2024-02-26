package com.ecommerce.service;

import com.ecommerce.controller.model.Cart;
import com.ecommerce.controller.model.CartItem;
import com.ecommerce.controller.model.Product;
import com.ecommerce.exception.CartItemException;
import com.ecommerce.exception.UserException;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;
	
	public CartItem isCartItemExists(Cart cart, Product product, String size, Long userId);
	
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId)throws CartItemException;

}
