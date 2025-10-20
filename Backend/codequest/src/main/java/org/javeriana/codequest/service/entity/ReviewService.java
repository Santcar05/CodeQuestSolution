package org.javeriana.codequest.service.entity;

import java.util.List;

import org.javeriana.codequest.entity.Review;
import org.javeriana.codequest.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public void save(Review review) {
        reviewRepository.save(review);
    }

    public void delete(Review review) {
        reviewRepository.delete(review);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review findById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
