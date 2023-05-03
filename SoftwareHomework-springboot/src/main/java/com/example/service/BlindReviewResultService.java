package com.example.service;

import com.example.entity.BlindReviewResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BlindReviewResultService {
    List<BlindReviewResult> findAllBlindReviewResult();
}
