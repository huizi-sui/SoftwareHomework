package com.example.service.impl;

import com.example.dao.DefenseApprovalResultMapper;
import com.example.entity.DefenseApprovalResult;
import com.example.service.DefenseApprovalResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefenseApprovalResultServiceImpl implements DefenseApprovalResultService {
    @Autowired
    private DefenseApprovalResultMapper defenseApprovalResultMapper;

    @Override
    public void insert(DefenseApprovalResult defenseApprovalResult) {
        defenseApprovalResult.setStatus(1);
        defenseApprovalResultMapper.insert(defenseApprovalResult);
    }

    @Override
    public void update(DefenseApprovalResult defenseApprovalResult) {
        boolean exist = defenseApprovalResultMapper.existsWithPrimaryKey(defenseApprovalResult.getId());
        if(!exist) {
            insert(defenseApprovalResult);
        } else {
            defenseApprovalResultMapper.updateByPrimaryKey(defenseApprovalResult);
        }
    }
}
