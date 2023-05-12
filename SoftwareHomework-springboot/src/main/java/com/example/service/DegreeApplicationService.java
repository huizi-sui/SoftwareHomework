package com.example.service;

import com.example.entity.DegreeApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DegreeApplicationService {

    void insert(Long id);

    void update(DegreeApplication degreeApplication) throws Exception;
    List<DegreeApplication> findAllDegreeApplication();

    DegreeApplication findById(Long id);
}
