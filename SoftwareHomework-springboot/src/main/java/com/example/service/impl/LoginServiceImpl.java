package com.example.service.impl;

import com.example.Unit.StaticValue;
import com.example.dao.LoginMapper;
import com.example.entity.Login;
import com.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public int addLogin(Login login) {
        Login existLogin = findLoginById(login.getId());
        if(existLogin != null) {
            return -1;
        }
        long id = loginMapper.count() + StaticValue.ID_INIT;
        login.setId(id);
        try {
            return loginMapper.insert(login);
        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Login findLoginById(Long id) {
        return loginMapper.selectLoginById(id);
    }

}
