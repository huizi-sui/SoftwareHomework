package com.example.service;

import com.example.entity.DefenseApprovalResult;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DefenseApprovalResultService {

    void insert(DefenseApprovalResult defenseApprovalResult);

    void update(DefenseApprovalResult defenseApprovalResult);
}
