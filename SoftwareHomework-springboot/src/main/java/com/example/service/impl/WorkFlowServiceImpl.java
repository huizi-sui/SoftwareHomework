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
    public boolean assuredSelfEvaluation(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setSelfEvaluation(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assuredUserInfo(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setUserInfo(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assuredBlindReview(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setBlindReview(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean findBlindReviewPreviewAssured(Long id) {
        WorkFlow workFlow = workFlowMapper.selectByPrimaryKey(id);
        if(null == workFlow) {
            return false;
        }
        if(workFlow.getUserInfo() == 2 && workFlow.getSelfEvaluation() == 2) {
            return true;
        }
        return false;
    }


    @Override
    public void insert(Long id) {
        WorkFlow workFlow = new WorkFlow();
        workFlow.setId(id);
        workFlow.setAllowDownload(1);
        workFlow.setBlindReview(1);
        workFlow.setBlindReviewResult(1);
        workFlow.setScoreSubmission(1);
        workFlow.setDefenseApproval(1);
        workFlow.setDegreeApplication(1);
        workFlow.setApprovalResult(1);
        workFlow.setSelfEvaluation(1);
        workFlow.setUserInfo(1);
        workFlow.setReviewSummary(1);
        workFlowMapper.insert(workFlow);
    }

    @Override
    public boolean findUserIsExist(Long id) {
        return workFlowMapper.existsWithPrimaryKey(id);
    }

    @Override
    public List<WorkFlow> findAllWorkFlow() {
        return workFlowMapper.selectAll();
    }

    @Override
    public boolean assuredDefenseApproval(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setDefenseApproval(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assuredAllowDownload(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setAllowDownload(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assuredApprovalResult(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setApprovalResult(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean findDefenseApprovalPreviewAssured(Long id) {
        WorkFlow workFlow = workFlowMapper.selectByPrimaryKey(id);
        if(null == workFlow) {
            return false;
        }
        if(workFlow.getUserInfo() == 2 && workFlow.getSelfEvaluation() == 2 &&
            workFlow.getBlindReview() == 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assuredBlindReviewResult(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setBlindReviewResult(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean assuredDefenseApprovalResult(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setScoreSubmission(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean findDegreeApplicationPreviewAssured(Long id) {
        WorkFlow workFlow = workFlowMapper.selectByPrimaryKey(id);
        if(null == workFlow) {
            return false;
        }
        if(workFlow.getUserInfo() == 2 && workFlow.getSelfEvaluation() == 2 &&
                workFlow.getBlindReview() == 2 && workFlow.getDefenseApproval() == 2 && workFlow.getBlindReviewResult() == 2 &&
                workFlow.getReviewSummary() == 2 && workFlow.getAllowDownload() == 2 && workFlow.getScoreSubmission() == 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean assuredDegreeApplication(Long id) {
        try {
            WorkFlow workFlow = new WorkFlow();
            workFlow.setId(id);
            workFlow.setDegreeApplication(2);
            workFlowMapper.updateByPrimaryKeySelective(workFlow);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public WorkFlow findById(Long id) {
        WorkFlow workFlow = workFlowMapper.selectByPrimaryKey(id);
        if(null == workFlow) {
            insert(id);
            workFlow = workFlowMapper.selectByPrimaryKey(id);
        }
        return workFlow;
    }
}
