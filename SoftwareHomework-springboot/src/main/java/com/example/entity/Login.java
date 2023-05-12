package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;

/**
 *   用户表
 */
@Table
@Data
@ToString
@ApiModel(value = "用户登录信息类")
public class Login extends BaseModel {
    // studentId
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id
    private Long id;
    // 权限
    @Column(name = "rid", type = MySqlTypeConstant.INT, defaultValue = "1")
    @ApiModelProperty(value = "权限")
    private Integer rid;

    @Column(name = "email", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "邮箱")
    private String email;

    @Column(name = "password", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "密码")
    private String password;
}
