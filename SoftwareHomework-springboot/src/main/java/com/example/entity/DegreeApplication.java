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
 *学位申请表
 */
@Data
@ToString
@Table
@ApiModel(value = "学位申请表")
public class DegreeApplication {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id
    private Long id;

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 15, defaultValue = "待填写")
    @ApiModelProperty(value = "姓名", notes = "默认值为待填写")
    private String name;

    // 学院
    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    @ApiModelProperty(value = "学院")
    private String college;

    // 专业
    @Column(name = "major", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "软件工程专业")
    @ApiModelProperty(value = "专业学位类别")
    private String major;

    // 导师姓名
    @Column(name = "boss_name", type = MySqlTypeConstant.VARCHAR, length = 10)
    @ApiModelProperty(value = "导师姓名")
    private String bossName;

    // 导师职称
    @Column(name = "boss_title", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "导师职称")
    private String bossTitle;

    // 申请的学位
    @Column(name = "degree", type = MySqlTypeConstant.VARCHAR, length = 50, defaultValue = "专业硕士学位")
    @ApiModelProperty(value = "申请的学位")
    private String degree;

    // 是否审批
    @Column(name = "admin_is_agree", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "是否已经审批", notes = "1是未审批，2是已经审批")
    private Integer adminIsAgree;
}
