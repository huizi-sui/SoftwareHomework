package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import java.sql.Date;
/**
 * 待确认信息表
 */
@Data
@ToString
@Table
@ApiModel(value = "待确认信息表（用户信息表）")
public class UserInfo {
    // student id
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id
    private Long id;

    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 15, defaultValue = "待填写")
    @ApiModelProperty(value = "姓名", notes = "默认值为待填写")
    private String name;

    @Column(name = "email", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "邮箱", notes = "不超过20字符，未做字符串通配测试")
    private String email;

    @Column(name = "sex", type = MySqlTypeConstant.VARCHAR, length = 10, defaultValue = "男")
    @ApiModelProperty(value = "性别", notes = "默认为男")
    private String sex;

    // 第几届学生
    @Column(name = "level", type = MySqlTypeConstant.INT, defaultValue = "22")
    @ApiModelProperty(value = "第几届学生", notes = "默认为22")
    private Integer level;

    // 预毕业日期
    @Column(name = "date", type = MySqlTypeConstant.DATE, defaultValue = "2025-06-22")
    @ApiModelProperty(value = "预毕业日期", notes = "格式为YYYY-MM-DD,默认为2025-06-22")
    private Date date;

    // 学院
    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    @ApiModelProperty(value = "所在学院", notes = "默认为软件学院")
    private String college;

    // 专业
    @Column(name = "major", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "软件工程专业")
    @ApiModelProperty(value = "所修专业", notes = "默认为软件工程专业")
    private String major;

    // 学位审批结果
    @Column(name = "approval_result", type = MySqlTypeConstant.VARCHAR, length = 50, defaultValue = "暂未获得学位")
    @ApiModelProperty(value = "学位审批结果", notes = "默认为暂未获得学位")
    private String approvalResult;
}
