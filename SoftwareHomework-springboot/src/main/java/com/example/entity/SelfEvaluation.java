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
 * 自评论文预审表
 */
@Data
@ToString
@Table
@ApiModel(value = "自评论文预审表")
public class SelfEvaluation {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    @Id // 用于tk.mybatis
    private Long id;

    // 学生姓名
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 10)
    private String name;

    // 学院
    @Column(name = "college", type = MySqlTypeConstant.VARCHAR, length = 30, defaultValue = "软件学院")
    @ApiModelProperty(value = "所在学院", notes = "默认为软件学院")
    private String college;

    // 专业
    @Column(name = "major", type = MySqlTypeConstant.VARCHAR, length = 20, defaultValue = "软件工程专业")
    @ApiModelProperty(value = "所修专业", notes = "默认为软件工程专业")
    private String major;

    // 导师姓名
    @Column(name = "boss_name", type = MySqlTypeConstant.VARCHAR, length = 10)
    @ApiModelProperty(value = "导师姓名")
    private String bossName;

    // 导师职称
    @Column(name = "boss_title", type = MySqlTypeConstant.VARCHAR, length = 20)
    @ApiModelProperty(value = "导师职称")
    private String bossTitle;

    // 导师工作单位
    @Column(name = "boss_work", type = MySqlTypeConstant.VARCHAR, length = 30)
    @ApiModelProperty(value = "导师工作单位")
    private String bossWork;

    // 导师从事领域
    @Column(name = "boss_filed", type = MySqlTypeConstant.VARCHAR, length = 50)
    @ApiModelProperty(value = "导师从事领域")
    private String bossFiled;

    // 论文题目
    @Column(name = "title", type = MySqlTypeConstant.VARCHAR, length = 50)
    @ApiModelProperty(value = "论文题目", notes = "不超过50字符")
    private String title;

    // 论文关键词
    @Column(name = "key_words", type = MySqlTypeConstant.VARCHAR, length = 30)
    @ApiModelProperty(value = "论文关键词")
    private String keyWords;

    // 摘要
    @Column(name = "summary", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "摘要", notes = "不超过300字符")
    private String summary;

    // 自我评价
    @Column(name = "self_review", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "自我评价", notes = "不超过300字符")
    private String selfReview;

}
