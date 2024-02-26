package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.model.Rating;
import com.ecommerce.controller.model.User;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.request.RatingRequest;
import com.ecommerce.service.RatingService;
import com.ecommerce.service.UserService;

import ch.qos.logback.core.model.processor.ProcessorException;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req,
			@RequestHeader("Authorization") String jwt)throws UserException, ProcessorException, ProductException{
		User user= userService.findUserProfileByJwt(jwt);
		
		Rating rating = ratingService.createRating(req, user);
		
		return new ResponseEntity<Rating>(rating, HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Rating>> getProductRating(@PathVariable Long productId,
			@RequestHeader("Authorization")String jwt)throws UserException, ProductException{
		User user= userService.findUserProfileByJwt(jwt);
		
		List<Rating> ratings= ratingService.getProductRating(productId);
		
		return new ResponseEntity<>(ratings, HttpStatus.CREATED);
	}
	

}
