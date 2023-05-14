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
 * 盲审查重表
 */
@Data
@ToString
@Table
@ApiModel(value = "盲审查重结果表")
public class BlindReview {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id
    private Long id;

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 15)
    @ApiModelProperty(value = "姓名")
    private String name;

    // 论文题目
    @Column(name = "title", type = MySqlTypeConstant.VARCHAR, length = 50)
    @ApiModelProperty(value = "论文题目")
    private String title;

    // 论文查重百分比
    @Column(name = "duplicate_score", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    @ApiModelProperty(value = "论文查重百分比")
    private Float duplicateScore;

    // 论文盲审评阅老师
    @Column(name = "blind_teacher1", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "无")
    @ApiModelProperty(value = "论文盲审评阅老师1")
    private String blindTeacher1;

    // 论文盲审评阅老师
    @Column(name = "blind_teacher2", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "无")
    @ApiModelProperty(value = "论文盲审评阅老师2")
    private String blindTeacher2;

    // 是否已经上传论文
    @Column(name = "status", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "是否已经上传论文", notes = "1代表未上传；2代表已经上传")
    private Integer status;

    @Column(name = "approval_status", type = MySqlTypeConstant.INT, defaultValue = "1")
    @ApiModelProperty(value = "待盲审是4， 盲审中是1， 盲审不通过是2， 盲审通过是3")
    private Integer approvalStatus;
}
