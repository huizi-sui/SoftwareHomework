package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

/**
 * 成绩表（盲审，答辩。。。）
 */
@Data
@ToString
@Table
public class Score {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    private Long id;

    // 盲审成绩，取盲审表中的平均值
    @Column(name = "blindScore", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    private Float blindScore;

    // 答辩成绩
    @Column(name = "defenseScore", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    private Float defenseScore;
}
