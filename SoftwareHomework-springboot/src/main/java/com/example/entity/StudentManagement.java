package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table
@ApiModel(value = "学生管理")
@EqualsAndHashCode
public class StudentManagement {
    @Column(name = "student_id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id
    private Long StudentId;

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 15, defaultValue = "待填写")
    @ApiModelProperty(value = "姓名", notes = "默认值为待填写")
    private String name;

    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    @ApiModelProperty(value = "所在学院", notes = "默认为软件学院")
    private String college;

    @Column(name = "major", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "软件工程专业")
    @ApiModelProperty(value = "所修专业", notes = "默认为软件工程专业")
    private String major;

    @Column(name = "sex", type = MySqlTypeConstant.VARCHAR, length = 10)
    @ApiModelProperty(value = "性别")
    private String sex;

    // 权限
    @Column(name = "rid", type = MySqlTypeConstant.INT, defaultValue = "1")
    @ApiModelProperty(value = "权限")
    private Integer rid;

    @Column(name = "defense_score", type = MySqlTypeConstant.FLOAT, defaultValue = "0.0")
    @ApiModelProperty(value = "答辩成绩")
    private Float defenseScore;

    @Column(name = "chairman_name", type = MySqlTypeConstant.VARCHAR, length = 10)
    @ApiModelProperty(value = "答辩主席")
    private String chairmanName;

    @Column(name = "admin_is_agree", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "审批是否通过", notes = "是则为2，不是为1，默认为1")
    private Integer adminIsAgree;

}
