package com.example.service.impl;

import com.example.dao.StudentManagementMapper;
import com.example.entity.StudentManagement;
import com.example.service.StudentManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManagementImpl implements StudentManagementService {
    @Autowired
    private StudentManagementMapper studentManagementMapper;
    @Override
    public List<StudentManagement> findAll() {
        Example example = new Example(StudentManagement.class);
        example.setOrderByClause("student_id ASC");
        return studentManagementMapper.selectByExample(example);
    }

    @Override
    public List<StudentManagement> findSome(StudentManagement studentManagement) {
        Example example = new Example(StudentManagement.class);
        if(studentManagement.getStudentId() != null){
            example.createCriteria().andEqualTo("student_id", studentManagement.getStudentId());
        }
        if(studentManagement.getName() != null){
            example.createCriteria().andEqualTo("name", studentManagement.getName());
        }
        if(studentManagement.getCollege() != null){
            example.createCriteria().andEqualTo("college", studentManagement.getCollege());
        }
        if(studentManagement.getMajor() != null){
            example.createCriteria().andEqualTo("major", studentManagement.getMajor());
        }

        if(studentManagement.getDefenseScore() != null){
            example.createCriteria().andEqualTo("defense_score", studentManagement.getDefenseScore());
        }
        if(studentManagement.getChairmanName() != null){
            example.createCriteria().andEqualTo("chairman_name", studentManagement.getChairmanName());
        }
        if(studentManagement.getAdminIsAgree() != null){
            example.createCriteria().andEqualTo("admin_is_agree", studentManagement.getAdminIsAgree());
        }
        example.setOrderByClause("student_id ASC");
        return studentManagementMapper.selectByExample(example);
    }

    @Override
    public boolean update(StudentManagement studentManagement) {
        Example example = new Example(StudentManagement.class);
        example.createCriteria().andEqualTo("student_id", studentManagement.getStudentId());
        try{
            studentManagementMapper.updateByExample(studentManagement, example);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Long studentNumber) {
        try{
            studentManagementMapper.deleteByPrimaryKey(studentNumber);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}
