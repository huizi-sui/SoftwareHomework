package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

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
    private Long id;

    // 论文题目
    @Column(name = "title", type = MySqlTypeConstant.VARCHAR, length = 50)
    @ApiModelProperty(value = "论文题目", notes = "不超过50字符")
    private String title;

    // 摘要
    @Column(name = "summary", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "摘要", notes = "不超过300字符")
    private String summary;

    // 自我评价
    @Column(name = "selfReview", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "自我评价", notes = "不超过300字符")
    private String selfReview;

}
