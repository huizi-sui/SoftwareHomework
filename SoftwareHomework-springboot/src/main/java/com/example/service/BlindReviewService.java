package com.example.service;

import com.example.entity.BlindReview;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BlindReviewService {
    BlindReview findBlindReviewById(Long id);

    void insert(Long id);

    void update(BlindReview blindReview);

    void update(Long id, Integer approvalStatus);

    boolean exist(Long id);
}
