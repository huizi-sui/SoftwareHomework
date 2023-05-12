package com.example.service;

import com.example.entity.Approve;
import com.example.entity.BlindReview;
import com.example.entity.DefenseApproval;
import com.example.entity.DegreeApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ApproveService {
    void add(DefenseApproval defenseApproval);

    void add(DegreeApplication degreeApplication);

    void add(BlindReview blindReview);

    void update(DefenseApproval defenseApproval, String approvalName);

    List<Approve> findAll();

    List<Approve> findSome(Approve approve);
}
