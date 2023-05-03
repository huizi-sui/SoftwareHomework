package com.example.service;

import com.example.entity.WorkFlow;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WorkFlowService {
    List<WorkFlow> findAllWorkFlow();
}
