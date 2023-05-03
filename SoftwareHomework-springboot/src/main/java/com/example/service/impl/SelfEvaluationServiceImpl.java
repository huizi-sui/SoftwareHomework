package com.example.service.impl;

import com.example.dao.SelfEvaluationMapper;
import com.example.entity.SelfEvaluation;
import com.example.service.SelfEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfEvaluationServiceImpl implements SelfEvaluationService {
    @Autowired
    private SelfEvaluationMapper selfEvaluationMapper;
    @Override
    public List<SelfEvaluation> findAllSelfEvaluation() {
        return selfEvaluationMapper.selectAll();
    }
}
