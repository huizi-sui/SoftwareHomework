package com.example.service.impl;

import com.example.dao.ScoreMapper;
import com.example.entity.Score;
import com.example.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Override
    public List<Score> findAllScore() {
        return scoreMapper.selectAll();
    }
}
