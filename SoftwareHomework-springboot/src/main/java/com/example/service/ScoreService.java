package com.example.service;

import com.example.entity.Score;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ScoreService {
    List<Score> findAllScore();
}
