package com.example.service.impl;

import com.example.dao.DefenseApprovalMapper;
import com.example.dao.SelfEvaluationMapper;
import com.example.entity.DefenseApproval;
import com.example.entity.SelfEvaluation;
import com.example.service.DefenseApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DefenseApprovalServiceImpl implements DefenseApprovalService {
    @Autowired
    private DefenseApprovalMapper defenseApprovalMapper;
    @Autowired
    private SelfEvaluationMapper selfEvaluationMapper;

    @Override
    public void update(DefenseApproval defenseApproval) throws Exception {
        DefenseApproval exist = defenseApprovalMapper.selectByPrimaryKey(defenseApproval.getId());
        System.out.println(exist);
        if(exist.getAdminIsAgree() != null && exist.getAdminIsAgree() == 3) {
            throw new Exception("审批通过，不允许轻易更改");
        }
        defenseApprovalMapper.updateByPrimaryKeySelective(defenseApproval);
    }

    @Override
    public void insert(Long id) {
        DefenseApproval defenseApproval = new DefenseApproval();
        defenseApproval.setId(id);
        defenseApproval.setAdminIsAgree(4);

        SelfEvaluation selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
        if(selfEvaluation != null && selfEvaluation.getName() != null) {
            defenseApproval.setName(selfEvaluation.getName());
            defenseApproval.setTitle(selfEvaluation.getTitle());
        }
        defenseApprovalMapper.insert(defenseApproval);
    }

    @Override
    public List<DefenseApproval> findAllDefenseApproval() {
        return defenseApprovalMapper.selectAll();
    }

    @Override
    public DefenseApproval findById(Long id) {
        DefenseApproval defenseApproval = defenseApprovalMapper.selectByPrimaryKey(id);
        if(null == defenseApproval) {
            insert(id);
            defenseApproval = defenseApprovalMapper.selectByPrimaryKey(id);
        } else {
            if(defenseApproval.getName() == null) {
                SelfEvaluation selfEvaluation = selfEvaluationMapper.selectByPrimaryKey(id);
                if(selfEvaluation != null && selfEvaluation.getName() != null) {
                    defenseApproval.setName(selfEvaluation.getName());
                    defenseApproval.setTitle(selfEvaluation.getTitle());
                }
            }
        }
        return defenseApproval;
    }
}
