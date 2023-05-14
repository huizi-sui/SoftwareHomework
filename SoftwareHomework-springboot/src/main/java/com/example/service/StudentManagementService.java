package com.example.service;

import com.example.entity.StudentManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudentManagementService {
    List<StudentManagement> findAll();

    List<StudentManagement> findSome(StudentManagement studentManagement);

    boolean update(StudentManagement studentManagement);

    boolean delete(Long studentNumber);

}
