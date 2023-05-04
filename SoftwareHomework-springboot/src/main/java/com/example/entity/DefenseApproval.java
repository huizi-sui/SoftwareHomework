package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * 评阅答辩审批表
 */
@Data
@ToString
@Table
@ApiModel(value = "评阅答辩审批表")
public class DefenseApproval {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    private Long id;

    // 评阅
    @Column(name = "review", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "评阅内容")
    private String review;

    // 答辩时间
    @Column(name = "defenseTime", type = MySqlTypeConstant.DATETIME)
    @ApiModelProperty(value = "答辩时间", notes = "格式为YYYY-MM-DD HH:mm:ss")
    private Timestamp defenseTime;

    // 工作单位
    @Column(name = "employer", type = MySqlTypeConstant.VARCHAR, length = 100)
    @ApiModelProperty(value = "工作单位")
    private String employer;

    // 是否是博导
    @Column(name = "isDoctor", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "是否是博导", notes = "是则为2，不是为1，默认为1")
    private Integer isDoctor;
}
