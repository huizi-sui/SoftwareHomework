package com.example.service;

import com.example.entity.DefenseApproval;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DefenseApprovalService {
    List<DefenseApproval> findAllDefenseApproval();
}
