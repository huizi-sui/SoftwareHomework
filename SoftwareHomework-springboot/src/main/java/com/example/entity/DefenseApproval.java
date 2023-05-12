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

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 15)
    @ApiModelProperty(value = "姓名")
    private String name;

    // 论文题目
    @Column(name = "title", type = MySqlTypeConstant.VARCHAR, length = 100)
    @ApiModelProperty(value = "论文题目")
    private String title;

    // 答辩时间
    @Column(name = "defenseTime", type = MySqlTypeConstant.DATETIME)
    @ApiModelProperty(value = "答辩时间", notes = "格式为YYYY-MM-DD HH:mm:ss")
    private Timestamp defenseTime;

    // 答辩委员会主席
    // 姓名
    @Column(name = "chairman_name", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会主席姓名")
    private String chairmanName;

    // 职称
    @Column(name = "chairman_title", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会主席职称")
    private String chairmanTitle;

    // 工作单位
    @Column(name = "chairman_employer", type = MySqlTypeConstant.VARCHAR, length = 100)
    @ApiModelProperty(value = "答辩委员会主席工作单位")
    private String chairman_employer;

    // 是否是博导
    @Column(name = "chairman_is_doctor", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "答辩委员会主席是否是博导", notes = "是则为2，不是为1，默认为1")
    private Integer chairmanIsDoctor;

    // 答辩委员会委员，三个，1， 2 ，3
    // 1
    @Column(name = "member1_name", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会委员姓名")
    private String member1Name;

    // 职称
    @Column(name = "member1_title", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会委员职称")
    private String member1Title;

    // 工作单位
    @Column(name = "member1_employer", type = MySqlTypeConstant.VARCHAR, length = 100)
    @ApiModelProperty(value = "答辩委员会委员工作单位")
    private String member1_employer;

    // 是否是博导
    @Column(name = "member1_is_doctor", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "答辩委员会委员是否是博导", notes = "是则为2，不是为1，默认为1")
    private Integer member1IsDoctor;

    // 2
    @Column(name = "member2_name", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会委员姓名")
    private String member2Name;

    // 职称
    @Column(name = "member2_title", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会委员职称")
    private String member2Title;

    // 工作单位
    @Column(name = "member2_employer", type = MySqlTypeConstant.VARCHAR, length = 100)
    @ApiModelProperty(value = "答辩委员会委员工作单位")
    private String member2_employer;

    // 是否是博导
    @Column(name = "member2_is_doctor", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "答辩委员会委员是否是博导", notes = "是则为2，不是为1，默认为1")
    private Integer member2IsDoctor;

    // 3
    @Column(name = "member3_name", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会委员姓名")
    private String member3Name;

    // 职称
    @Column(name = "member3_title", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "答辩委员会委员职称")
    private String member3Title;

    // 工作单位
    @Column(name = "member3_employer", type = MySqlTypeConstant.VARCHAR, length = 100)
    @ApiModelProperty(value = "答辩委员会委员工作单位")
    private String member3_employer;

    // 是否是博导
    @Column(name = "member3_is_doctor", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "答辩委员会委员是否是博导", notes = "是则为2，不是为1，默认为1")
    private Integer member3IsDoctor;
}
