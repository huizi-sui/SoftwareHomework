package com.example.service;

import com.example.entity.BlindReviewResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BlindReviewResultService {

    void update(BlindReviewResult blindReviewResult);

    boolean exist(Long id);

    BlindReviewResult findById(Long id);

    void insert(BlindReviewResult blindReviewResult);
    List<BlindReviewResult> findAllBlindReviewResult();
}
