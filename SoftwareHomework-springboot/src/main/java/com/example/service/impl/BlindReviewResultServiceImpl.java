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
    public void insert(BlindReviewResult blindReviewResult) {
        blindReviewResult.setApprovalStatus(1);
        blindReviewResultMapper.insert(blindReviewResult);
    }
    @Override
    public void update(BlindReviewResult blindReviewResult) {
        boolean exist = blindReviewResultMapper.existsWithPrimaryKey(blindReviewResult.getId());
        if(!exist) {
            insert(blindReviewResult);
        } else {
            blindReviewResultMapper.updateByPrimaryKey(blindReviewResult);
        }
    }

    @Override
    public boolean exist(Long id) {
        return blindReviewResultMapper.existsWithPrimaryKey(id);
    }

    @Override
    public List<BlindReviewResult> findAllBlindReviewResult() {
        return blindReviewResultMapper.selectAll();
    }
}
