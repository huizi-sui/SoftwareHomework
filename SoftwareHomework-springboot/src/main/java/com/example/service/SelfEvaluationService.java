package com.example.service;

import com.example.entity.SelfEvaluation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SelfEvaluationService {
    List<SelfEvaluation> findAllSelfEvaluation();
}
