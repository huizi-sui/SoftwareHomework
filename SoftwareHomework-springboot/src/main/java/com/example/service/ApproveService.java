package com.example.service;

import com.example.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ApproveService {
    void add(DefenseApproval defenseApproval);

    void add(DegreeApplication degreeApplication);

    void add(BlindReview blindReview);

    void add(Long id);

    void update(DefenseApproval defenseApproval, String approvalName, Integer approvalId);

    void update(DegreeApplication degreeApplication, String approvalName, Integer approvalId);

    void update(DefenseApprovalResult defenseApprovalResult, String approvalName, Integer approvalId);

    void update(BlindReviewResult blindReviewResult, String approvalName, Integer approvalId);

    List<Approve> findAll();

    List<Approve> findSome(Approve approve);
}
