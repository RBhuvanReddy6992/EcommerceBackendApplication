package com.ecommerce.Review_Service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.Review_Service.Model.Review;
import com.ecommerce.Review_Service.Service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
    	 System.out.println("🔥 ReviewController LOADED 🔥");
        this.reviewService = reviewService;
    }

    // GET review by reviewId
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        return reviewService.getByreviewId(id);
    }

    // GET reviews by productId
    @GetMapping("/product/{id}")
    public ResponseEntity<List<Review>> getReviewsByProductId(@PathVariable int id) {
        return reviewService.getByproductId(id);
    }

    // GET reviews by userId
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable int id) {
        return reviewService.getuserById(id);
    }
}
