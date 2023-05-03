package com.example.service.impl;

import com.example.dao.BlindReviewResultMapper;
import com.example.entity.BlindReviewResult;
import com.example.service.BlindReviewResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlindReviewResultServiceImpl implements BlindReviewResultService {
    @Autowired
    private BlindReviewResultMapper blindReviewResultMapper;
    @Override
    public List<BlindReviewResult> findAllBlindReviewResult() {
        return blindReviewResultMapper.selectAll();
    }
}
