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
 * 盲审评阅总评
 *
 * 论文题目、论文关键字、论文摘要从论文预审表SelfEvaluation中查询
 */
@Data
@ToString
@ApiModel("盲审评阅总评")
@Table
public class BlindReviewResult {
    @Column(value = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id
    private Long id;

    @Column(name = "innovation", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "论文创新点")
    private String innovation;

    @Column(name = "comment", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "评阅意见", notes = "不超过300字符")
    private String comment;

    // 论文盲审分数
    @Column(name = "blind_score1", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    @ApiModelProperty(value = "论文盲审分数1")
    private Float blindScore1;

    // 论文盲审分数
    @Column(name = "blind_score2", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    @ApiModelProperty(value = "论文盲审分数2")
    private Float blindScore2;

    // 审批状态
    @Column(name = "approval_status", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "审批状态", notes = "1代表审批中，2代表审批失败，3代表审批通过")
    private Integer approvalStatus;
}
