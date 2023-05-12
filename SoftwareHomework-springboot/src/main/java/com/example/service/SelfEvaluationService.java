package com.example.service;

import com.example.entity.SelfEvaluation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SelfEvaluationService {

    void insert(Long id);

    boolean updateSelfEvaluation(SelfEvaluation selfEvaluation);
    List<SelfEvaluation> findAllSelfEvaluation();

    SelfEvaluation findById(Long id);
}
