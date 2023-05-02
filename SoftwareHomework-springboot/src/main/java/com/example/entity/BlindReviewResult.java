package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

/**
 * 盲审查重结果表
 */
@Data
@ToString
@Table
public class BlindReviewResult {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    private Long id;

    // 论文题目
    @Column(name = "title", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String title;

    // 论文查重百分比
    @Column(name = "duplicateScore", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    private Float duplicateScore;

    // 论文盲审评阅老师
    @Column(name = "blindTeacher1", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "无")
    private String blindTeacher1;

    // 论文盲审分数
    @Column(name = "blindScore1", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    private Float blindScore1;

    // 论文盲审评阅老师
    @Column(name = "blindTeacher2", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "无")
    private String blindTeacher2;

    // 论文盲审分数
    @Column(name = "blindScore2", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    private Float blindScore2;
}
