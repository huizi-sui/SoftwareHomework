package com.example.service;

import com.example.entity.BlindReviewResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BlindReviewResultService {

    void update(BlindReviewResult blindReviewResult);

    void insert(BlindReviewResult blindReviewResult);
    List<BlindReviewResult> findAllBlindReviewResult();
}
