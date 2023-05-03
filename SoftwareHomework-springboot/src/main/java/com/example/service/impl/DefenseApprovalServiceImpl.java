package com.example.service.impl;

import com.example.dao.DefenseApprovalMapper;
import com.example.entity.DefenseApproval;
import com.example.service.DefenseApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefenseApprovalServiceImpl implements DefenseApprovalService {
    @Autowired
    private DefenseApprovalMapper defenseApprovalMapper;
    @Override
    public List<DefenseApproval> findAllDefenseApproval() {
        return defenseApprovalMapper.selectAll();
    }
}
