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
 * 审批表
 */
@Data
@ToString
@Table
@ApiModel("审批表")
public class Approve {
    @Column(value = "id", type = MySqlTypeConstant.INT, isKey = true, isAutoIncrement = true)
    @ApiModelProperty("序号，自增")
    @Id
    private Integer id;

    @Column(value = "student_id", type = MySqlTypeConstant.BIGINT)
    @ApiModelProperty("学号")
    private Long studentId;

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 15)
    @ApiModelProperty(value = "学生姓名")
    private String name;

    // 学院
    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    @ApiModelProperty(value = "所在学院", notes = "默认为软件学院")
    private String college;

    @Column(name = "date", type = MySqlTypeConstant.VARCHAR, defaultValue = "2025-06-22", length = 30)
    @ApiModelProperty(value = "申请时间", notes = "格式为YYYY-MM-DD,默认为2025-06-22")
    private String date;

    @Column(name = "status", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "审核状态", notes = "默认为1，未审核；2是审核退回；3是审核通过")
    private Integer status;

    @Column(name = "approve_name", type = MySqlTypeConstant.VARCHAR, length = 15)
    @ApiModelProperty(value = "审批人")
    private String approveName;

    @Column(name = "category", type = MySqlTypeConstant.TINYINT)
    @ApiModelProperty(value = "申请类型，1. 评阅审批答辩，2. 盲审审批，3. 学位申请")
    private Integer category;

}
