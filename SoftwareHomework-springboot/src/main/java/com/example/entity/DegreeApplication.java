package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

/**
 *学位申请表
 */
@Data
@ToString
@Table
public class DegreeApplication {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    private Long id;

    // 学院
    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    private String college;

    // 专业
    @Column(name = "major", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "软件工程专业")
    private String major;

    // 申请的学位
    @Column(name = "degree", type = MySqlTypeConstant.VARCHAR, length = 50, defaultValue = "专业硕士学位")
    private String degree;
}
