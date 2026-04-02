package com.ecommerce.Review_Service.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.Review_Service.Model.Review;
import com.ecommerce.Review_Service.Repository.ReviewRepository;

@Service
public class ReviewService {

    private final ReviewRepository rr;

    public ReviewService(ReviewRepository rr) {
        this.rr = rr;
    }

    public ResponseEntity<Review> getByreviewId(int id) {
        System.out.println("Looking for review_id = " + id);
        return rr.findById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<List<Review>> getByproductId(int id) {
        return ResponseEntity.ok(rr.findByProductId(id));
    }

    public ResponseEntity<List<Review>> getuserById(int id) {
        return ResponseEntity.ok(rr.findByUserId(id));
    }
}
