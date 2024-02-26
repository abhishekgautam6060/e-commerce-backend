package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.model.ApiResponse;
import com.ecommerce.controller.model.CartItem;
import com.ecommerce.controller.model.User;
import com.ecommerce.exception.CartItemException;
import com.ecommerce.exception.UserException;
import com.ecommerce.service.CartItemService;
import com.ecommerce.service.UserService;


@RestController
@RequestMapping("/api/cart/item")
public class CartItemController {
	
	private CartItemService cartItemService;
	
	private UserService userService;
	
	public CartItemController(CartItemService cartItemService,UserService userService) {
		this.cartItemService=cartItemService;
		this.userService=userService;
		
	}
	
	
	@DeleteMapping("/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId
			,@RequestHeader("Authorization")String jwt) throws UserException, CartItemException{
		User user= userService.findUserProfileByJwt(jwt);
		
		System.out.println("Item deleted started");
		cartItemService.removeCartItem(user.getUserId(), cartItemId);
		
		
		
		ApiResponse res= new ApiResponse();
		res.setMessage("Item is successfully removed from cart");
		res.setStatus(true);
		
		return new ResponseEntity<>(res, HttpStatus.OK);
		
	}
	
	@PutMapping("/{cartItemId}")
	public ResponseEntity<CartItem> updateCartItem(
			@RequestBody CartItem cartItem,
			@RequestHeader("Authorization")String jwt,
			@PathVariable Long cartItemId)throws UserException, CartItemException{
		
		User user= userService.findUserProfileByJwt(jwt);
		CartItem updateCartItem = cartItemService.updateCartItem(user.getUserId(), cartItemId, cartItem);
		
		return new ResponseEntity<>(updateCartItem, HttpStatus.OK);
	
	}

}
