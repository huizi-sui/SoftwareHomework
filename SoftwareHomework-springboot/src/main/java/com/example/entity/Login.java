package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

/**
 *   用户表
 */
@Table
@Data
@ToString
public class Login extends BaseModel {
    // studentId
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    private Long id;
    // 权限
    @Column(name = "rid", type = MySqlTypeConstant.INT, defaultValue = "1")
    private Integer rid;

    @Column(name = "email", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String email;

    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String password;
}
