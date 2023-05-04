package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 *学位申请表
 */
@Data
@ToString
@Table
@ApiModel(value = "学位申请表")
public class DegreeApplication {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    private Long id;

    // 学院
    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    @ApiModelProperty(value = "学院")
    private String college;

    // 专业
    @Column(name = "major", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "软件工程专业")
    @ApiModelProperty(value = "专业")
    private String major;

    // 申请的学位
    @Column(name = "degree", type = MySqlTypeConstant.VARCHAR, length = 50, defaultValue = "专业硕士学位")
    @ApiModelProperty(value = "申请的学位")
    private String degree;
}
