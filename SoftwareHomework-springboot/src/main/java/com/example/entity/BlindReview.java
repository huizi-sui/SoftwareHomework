package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 盲审评阅总评
 *
 * 论文题目、论文关键字、论文摘要从论文预审表SelfEvaluation中查询
 */
@Data
@ToString
@ApiModel("盲审评阅总评")
@Table
public class BlindReview {
    @Column(value = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    private Long id;

    @Column(name = "innovation", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "论文创新点")
    private String innovation;

    @Column(name = "comment", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "评阅意见", notes = "不超过300字符")
    private String comment;



}
