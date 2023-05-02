package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

import java.sql.Date;
/**
 * 待确认信息表
 */
@Data
@ToString
@Table
public class UserInfo {
    // student id
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    private Long id;

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 15)
    private String name;

    @Column(name = "email", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String email;

    @Column(name = "sex", type = MySqlTypeConstant.VARCHAR, length = 10, defaultValue = "男")
    private String sex;

    // 预毕业日期
    @Column(name = "date", type = MySqlTypeConstant.DATE, defaultValue = "2023-06-22")
    private Date date;

    // 学院
    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    private String college;

    // 专业
    @Column(name = "major", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "软件工程专业")
    private String major;

    // 学位审批结果
    @Column(name = "approvalResult", type = MySqlTypeConstant.VARCHAR, length = 50, defaultValue = "暂未获得学位")
    private String approvalResult;
}
