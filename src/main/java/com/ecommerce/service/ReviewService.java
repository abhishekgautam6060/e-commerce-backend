package com.ecommerce.service;

import java.util.List;

import com.ecommerce.controller.model.Review;
import com.ecommerce.controller.model.User;
import com.ecommerce.exception.ProductException;
import com.ecommerce.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req, User user)throws ProductException;
	
	public List<Review> getAllReview(Long productId);
}
