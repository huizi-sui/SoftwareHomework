package com.example.service.impl;

import com.example.dao.SelfEvaluationMapper;
import com.example.dao.UserInfoMapper;
import com.example.entity.SelfEvaluation;
import com.example.entity.UserInfo;
import com.example.service.SelfEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfEvaluationServiceImpl implements SelfEvaluationService {
    @Autowired
    private SelfEvaluationMapper selfEvaluationMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void insert(Long id) {
        SelfEvaluation selfEvaluation = new SelfEvaluation();
        selfEvaluation.setId(id);
        selfEvaluation.setCollege("软件学院");
        selfEvaluation.setMajor("软件工程专业");

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if(userInfo != null) {
            selfEvaluation.setName(userInfo.getName());
        }
        selfEvaluationMapper.insert(selfEvaluation);
    }

    @Override
    public boolean updateSelfEvaluation(SelfEvaluation selfEvaluation) {
        try {
            selfEvaluationMapper.updateByPrimaryKeySelective(selfEvaluation);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<SelfEvaluation> findAllSelfEvaluation() {
        return selfEvaluationMapper.selectAll();
    }

    @Override
    public SelfEvaluation findById(Long id) {
        SelfEvaluation selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
        if(selfEvaluation == null) {
            insert(id);
            selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
        } else {
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
            if(userInfo != null) {
                selfEvaluation.setName(userInfo.getName());
            }
        }
        return selfEvaluation;
    }
}
