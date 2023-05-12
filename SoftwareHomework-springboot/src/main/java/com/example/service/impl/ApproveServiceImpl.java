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
    public void add(DefenseApproval defenseApproval) {
        Approve approve = new Approve();
        approve.setStudentId(defenseApproval.getId());
        approve.setDate(defenseApproval.getDefenseTime());

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(defenseApproval.getId());
        approve.setCollege(userInfo.getCollege());
        approve.setName(userInfo.getName());
        approveMapper.insert(approve);
    }

    @Override
    public void add(DegreeApplication degreeApplication) {
        Approve approve = new Approve();
        approve.setStudentId(degreeApplication.getId());
        LocalDate currentDate = LocalDate.now();
        approve.setDate(Date.valueOf(currentDate));

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(degreeApplication.getId());
        approve.setCollege(userInfo.getCollege());
        approve.setName(degreeApplication.getName());

        approveMapper.insert(approve);
    }

    @Override
    public void add(BlindReview blindReview) {
        Approve approve = new Approve();
        approve.setStudentId(blindReview.getId());
        LocalDate currentDate = LocalDate.now();
        approve.setDate(Date.valueOf(currentDate));

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(blindReview.getId());
        approve.setCollege(userInfo.getCollege());
        approve.setName(blindReview.getName());
    }

    @Override
    public void update(DefenseApproval defenseApproval, String approvalName) {
        Approve approve = new Approve();
        // 1: 不同意， status： 2
        // 2：同意， status: 3
        approve.setStatus(defenseApproval.getAdminIsAgree() + 1);
        approve.setApproveName(approvalName);

        Example example = new Example(Approve.class);
        example.createCriteria().andEqualTo("student_id", defenseApproval.getId());
        example.createCriteria().andEqualTo("date", defenseApproval.getDefenseTime());
        approveMapper.updateByExample(approve, example);
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
