package com.ecommerce.service;

import java.util.List;

import com.ecommerce.controller.model.Rating;
import com.ecommerce.controller.model.User;
import com.ecommerce.exception.ProductException;
import com.ecommerce.request.RatingRequest;

public interface RatingService {
	
	public Rating createRating(RatingRequest re, User user)throws ProductException;
	
	public List<Rating> getProductRating(Long productId);
	
	
		

}
