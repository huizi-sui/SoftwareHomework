package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * 评阅答辩审批表
 */
@Data
@ToString
@Table
public class DefenseApproval {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    private Long id;

    // 评阅
    @Column(name = "review", type = MySqlTypeConstant.VARCHAR, length = 300)
    private String review;

    // 答辩时间
    @Column(name = "defenseTime", type = MySqlTypeConstant.DATETIME)
    private Timestamp defenseTime;

    // 工作单位
    @Column(name = "employer", type = MySqlTypeConstant.VARCHAR, length = 100)
    private String employer;

    // 是否是博导
    @Column(name = "isDoctor", type = MySqlTypeConstant.TINYINT, defaultValue = "0")
    private String isDoctor;
}
