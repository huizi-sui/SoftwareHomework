package com.example.service.impl;

import com.example.dao.WorkFlowMapper;
import com.example.entity.WorkFlow;
import com.example.service.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkFlowServiceImpl implements WorkFlowService {
    @Autowired
    private WorkFlowMapper workFlowMapper;
    @Override
    public List<WorkFlow> findAllWorkFlow() {
        return workFlowMapper.selectAll();
    }
}
