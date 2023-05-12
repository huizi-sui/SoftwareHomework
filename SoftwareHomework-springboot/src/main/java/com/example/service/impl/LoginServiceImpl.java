package com.example.service.impl;

import com.example.Unit.StaticValue;
import com.example.dao.*;
import com.example.entity.*;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    // 初始化用户各个表中数据
    @Autowired
    private BlindReviewResultMapper blindReviewResultMapper;
    @Autowired
    private DefenseApprovalMapper defenseApprovalMapper;
    @Autowired
    private DegreeApplcationMapper degreeApplcationMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private SelfEvaluationMapper selfEvaluationMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private WorkFlowMapper workFlowMapper;
    @Override
    public int addLogin(Login login) {
        Login existLogin = findLoginById(login.getId());
        if(existLogin != null) {
            return -1;
        }
        long id = loginMapper.count() + StaticValue.ID_INIT;
        login.setId(id);
        try {
            loginMapper.insert(login);
            return 1;
        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Login findLoginById(Long id) {
        return loginMapper.selectLoginById(id);
    }

    @Override
    public List<Login> findAllLogin() {
        return loginMapper.selectAll();
    }

}
