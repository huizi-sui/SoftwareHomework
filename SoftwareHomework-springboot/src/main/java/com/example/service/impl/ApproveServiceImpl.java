package com.example.service.impl;

import com.example.dao.ApproveMapper;
import com.example.dao.UserInfoMapper;
import com.example.entity.*;
import com.example.service.ApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ApproveServiceImpl implements ApproveService {
    @Autowired
    private ApproveMapper approveMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void add(Long id) {
        Approve approve = new Approve();
        approve.setStudentId(id);
        approve.setCategory(4);
        LocalDate currentDate = LocalDate.now();
        approve.setDate(Date.valueOf(currentDate));
        approve.setStatus(1);

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        approve.setName(userInfo.getName());
        approve.setCollege(userInfo.getCollege());

        approveMapper.insert(approve);
    }
    @Override
    public void add(DefenseApproval defenseApproval) {
        Approve approve = new Approve();
        approve.setStudentId(defenseApproval.getId());
        LocalDate currentDate = LocalDate.now();
        approve.setDate(Date.valueOf(currentDate));
        approve.setStatus(1);

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(defenseApproval.getId());
        approve.setCollege(userInfo.getCollege());
        approve.setName(userInfo.getName());
        approve.setCategory(1);
        approveMapper.insert(approve);
    }

    @Override
    public void add(DegreeApplication degreeApplication) {
        Approve approve = new Approve();
        approve.setStudentId(degreeApplication.getId());
        LocalDate currentDate = LocalDate.now();
        approve.setDate(Date.valueOf(currentDate));
        approve.setStatus(1);

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(degreeApplication.getId());
        approve.setCollege(userInfo.getCollege());
        approve.setName(degreeApplication.getName());
        approve.setCategory(3);

        approveMapper.insert(approve);
    }

    @Override
    public void add(BlindReview blindReview) {
        Approve approve = new Approve();
        approve.setStudentId(blindReview.getId());
        LocalDate currentDate = LocalDate.now();
        approve.setDate(Date.valueOf(currentDate));
        approve.setStatus(1);

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(blindReview.getId());
        approve.setCollege(userInfo.getCollege());
        approve.setName(blindReview.getName());
        approve.setCategory(2);

        approveMapper.insert(approve);
    }

    @Override
    public void update(DefenseApproval defenseApproval, String approvalName, Integer approvalId) {
        Approve approve = new Approve();
        approve.setId(approvalId);
        // 1: 不同意， status： 2
        // 2：同意， status: 3
        approve.setStatus(defenseApproval.getAdminIsAgree());
        approve.setApproveName(approvalName);

        approveMapper.updateByPrimaryKeySelective(approve);
    }

    @Override
    public void update(DegreeApplication degreeApplication, String approvalName, Integer approvalId) {
        Approve approve = new Approve();
        // 1: 不同意， status： 2
        // 2：同意， status: 3
        approve.setId(approvalId);
        approve.setStatus(degreeApplication.getAdminIsAgree());
        approve.setApproveName(approvalName);

        approveMapper.updateByPrimaryKey(approve);
    }

    @Override
    public void update(DefenseApprovalResult defenseApprovalResult, String approvalName, Integer approvalId) {
        Approve approve = new Approve();
        // 1: 不同意， status： 2
        // 2：同意， status: 3
        approve.setId(approvalId);
        approve.setApproveName(approvalName);
        approve.setStatus(defenseApprovalResult.getStatus());
        approveMapper.updateByPrimaryKey(approve);
    }

    @Override
    public void update(BlindReviewResult blindReviewResult, String approvalName, Integer approvalId) {
        Approve approve = new Approve();
        // 1: 不同意， status： 2
        // 2：同意， status: 3
        approve.setId(approvalId);
        approve.setStatus(blindReviewResult.getApprovalStatus());
        approve.setApproveName(approvalName);

        approveMapper.updateByPrimaryKey(approve);
    }

    @Override
    public List<Approve> findAll() {
        Example example = new Example(Approve.class);
        example.setOrderByClause("date DESC");
        return approveMapper.selectByExample(example);
    }

    @Override
    public List<Approve> findSome(Approve approve) {
        Example example = new Example(Approve.class);
        if(approve.getStudentId() != null) {
            example.createCriteria().andEqualTo("student_id", approve.getStudentId());
        }
        if(approve.getCollege() != null) {
            example.createCriteria().andEqualTo("college", approve.getCollege());
        }
        if(approve.getStatus() != 0) {
            example.createCriteria().andEqualTo("status", approve.getStatus());
        }
        if(approve.getName() != null) {
            example.createCriteria().andEqualTo("name", approve.getName());
        }
        example.setOrderByClause("date DESC");
        return approveMapper.selectByExample(example);
    }
}
