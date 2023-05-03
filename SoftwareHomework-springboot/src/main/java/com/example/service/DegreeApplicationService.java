package com.example.service;

import com.example.entity.DegreeApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DegreeApplicationService {
    List<DegreeApplication> findAllDegreeApplication();
}
