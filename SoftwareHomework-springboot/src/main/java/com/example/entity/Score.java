package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;

/**
 * 成绩表（盲审，答辩。。。）
 * 暂时用不上
 */
@Data
@ToString
@Table
@ApiModel(value = "成绩表")
public class Score {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id
    private Long id;

    // 盲审成绩，取盲审表中的平均值
    @Column(name = "blind_score", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    @ApiModelProperty(value = "盲审成绩", notes = "两位盲审评阅老师，成绩取平均值")
    private Float blindScore;

    // 答辩成绩
    @Column(name = "defense_score", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    @ApiModelProperty(value = "答辩成绩")
    private Float defenseScore;
}
