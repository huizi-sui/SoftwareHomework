package com.example.service.impl;

import com.example.dao.BlindReviewMapper;
import com.example.dao.SelfEvaluationMapper;
import com.example.entity.BlindReview;
import com.example.entity.SelfEvaluation;
import com.example.service.BlindReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlindReviewServiceImpl implements BlindReviewService {

    @Autowired
    private BlindReviewMapper blindReviewMapper;
    @Autowired
    private SelfEvaluationMapper selfEvaluationMapper;
    @Override
    public BlindReview findBlindReviewById(Long id) {
        BlindReview blindReview = blindReviewMapper.selectByPrimaryKey(id);
        if(blindReview == null) {
            insert(id);
            blindReview = blindReviewMapper.selectByPrimaryKey(id);
        } else if(blindReview.getName() == null) {
            SelfEvaluation selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
            if(selfEvaluation != null) {
                blindReview.setName(selfEvaluation.getName());
                blindReview.setTitle(blindReview.getTitle());
            }
        }
        return blindReview;
    }

    @Override
    public void insert(Long id) {
        BlindReview blindReview = new BlindReview();
        blindReview.setId(id);
        blindReview.setStatus(4);
        SelfEvaluation selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
        if(selfEvaluation != null) {
            blindReview.setName(selfEvaluation.getName());
            blindReview.setTitle(selfEvaluation.getTitle());
        }
        blindReviewMapper.insert(blindReview);
    }

    @Override
    public void update(BlindReview blindReview) {
        blindReviewMapper.updateByPrimaryKeySelective(blindReview);
    }
}
