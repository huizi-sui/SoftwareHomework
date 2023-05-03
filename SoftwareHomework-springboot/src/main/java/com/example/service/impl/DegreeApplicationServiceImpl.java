package com.example.service.impl;

import com.example.dao.DegreeApplcationMapper;
import com.example.entity.DegreeApplication;
import com.example.service.DegreeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeApplicationServiceImpl implements DegreeApplicationService {
    @Autowired
    private DegreeApplcationMapper degreeApplcationMapper;
    @Override
    public List<DegreeApplication> findAllDegreeApplication() {
        return degreeApplcationMapper.selectAll();
    }
}
