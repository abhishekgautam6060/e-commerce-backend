package com.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.model.ApiResponse;
import com.ecommerce.controller.model.Cart;
import com.ecommerce.controller.model.User;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.request.AddItemRequest;
import com.ecommerce.service.CartService;
import com.ecommerce.service.UserService;



@RestController
@RequestMapping("/api/cart")
public class CartController {

			
	private CartService cartService;
	
	private UserService userService;
	
	public CartController(CartService cartService, UserService userService) {		
		this.cartService=cartService;
		this.userService=userService;	
	}
	
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCart(@RequestHeader ("Authorization")String jwt)throws UserException{
		System.out.println("TEst - 2");
		
		User user = userService.findUserProfileByJwt(jwt);
		Cart cart= cartService.findUserCart(user.getUserId());
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/add")
	public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization")String jwt)throws UserException, ProductException{
		User user = userService.findUserProfileByJwt(jwt);
		
		cartService.addCartItem(user.getUserId(), req);
		
		ApiResponse res= new ApiResponse();
		res.setMessage("item Added to cart");
		res.setStatus(true);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	
	
	
}
