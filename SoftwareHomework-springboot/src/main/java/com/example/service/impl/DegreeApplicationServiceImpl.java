package com.example.service.impl;

import com.example.dao.DegreeApplcationMapper;
import com.example.dao.SelfEvaluationMapper;
import com.example.entity.DegreeApplication;
import com.example.entity.SelfEvaluation;
import com.example.service.DegreeApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DegreeApplicationServiceImpl implements DegreeApplicationService {
    @Autowired
    private DegreeApplcationMapper degreeApplcationMapper;
    @Autowired
    private SelfEvaluationMapper selfEvaluationMapper;

    @Override
    public void insert(Long id) {
        DegreeApplication degreeApplication = new DegreeApplication();
        degreeApplication.setId(id);
        degreeApplication.setAdminIsAgree(4);

        SelfEvaluation selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
        if(selfEvaluation!= null && selfEvaluation.getName() != null) {
            degreeApplication.setName(selfEvaluation.getName());
            degreeApplication.setCollege(selfEvaluation.getCollege());
            degreeApplication.setMajor(selfEvaluation.getMajor());
            degreeApplication.setBossName(selfEvaluation.getBossName());
            degreeApplication.setBossTitle(selfEvaluation.getBossTitle());
        }
        degreeApplcationMapper.insert(degreeApplication);
    }

    @Override
    public void update(DegreeApplication degreeApplication) throws Exception {
        DegreeApplication exist = degreeApplcationMapper.selectByPrimaryKey(degreeApplication.getId());
        if(exist.getAdminIsAgree() == 3) {
            throw new Exception("已经获得学位，不允许操作");
        } else {
            degreeApplcationMapper.updateByPrimaryKeySelective(degreeApplication);
        }
    }

    @Override
    public List<DegreeApplication> findAllDegreeApplication() {
        return degreeApplcationMapper.selectAll();
    }

    @Override
    public DegreeApplication findById(Long id) {
        DegreeApplication degreeApplication = degreeApplcationMapper.selectByPrimaryKey(id);
        if(degreeApplication == null) {
            insert(id);
            degreeApplication = degreeApplcationMapper.selectByPrimaryKey(id);
        }else {
            if(degreeApplication.getName() == null) {
                SelfEvaluation selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
                if(selfEvaluation!= null && selfEvaluation.getName() != null) {
                    degreeApplication.setName(selfEvaluation.getName());
                    degreeApplication.setCollege(selfEvaluation.getCollege());
                    degreeApplication.setMajor(selfEvaluation.getMajor());
                    degreeApplication.setBossName(selfEvaluation.getBossName());
                    degreeApplication.setBossTitle(selfEvaluation.getBossTitle());
                }
            }
        }
        return degreeApplication;
    }
}
