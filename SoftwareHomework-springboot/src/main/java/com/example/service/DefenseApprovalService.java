package com.example.service;

import com.example.entity.DefenseApproval;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DefenseApprovalService {

    void update(DefenseApproval defenseApproval) throws Exception;

    void update(Long id, Integer status);

    void insert(Long id);
    List<DefenseApproval> findAllDefenseApproval();

    DefenseApproval findById(Long id);
}
