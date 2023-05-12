package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * 评阅答辩审批结果表
 * 答辩委员会成员（主席、三位委员）的姓名、职称、工作单位、是否是博导信息到评阅答辩审批表中进行查询
 */
@Data
@ApiModel(value = "评阅审批答辩结果表")
@Table
@ToString
public class DefenseApprovalResult {

    @Column(value = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    @ApiModelProperty(value = "学号")
    private Long id;

    @Column(value = "score1", type = MySqlTypeConstant.FLOAT)
    @ApiModelProperty(value = "答辩委员会主席的打分")
    private Float score1;

    @Column(value = "score2", type = MySqlTypeConstant.FLOAT)
    @ApiModelProperty(value = "答辩委员会1号委员的打分")
    private Float score2;

    @Column(value = "score3", type = MySqlTypeConstant.FLOAT)
    @ApiModelProperty(value = "答辩委员会2号委员的打分")
    private Float score3;

    @Column(value = "score4", type = MySqlTypeConstant.FLOAT)
    @ApiModelProperty(value = "答辩委员会3号委员的打分")
    private Float score4;

    @Column(value = "comment", type = MySqlTypeConstant.VARCHAR, length = 300)
    @ApiModelProperty(value = "答辩委员会的答辩意见")
    private String comment;

    @Column(value = "score", type = MySqlTypeConstant.FLOAT)
    @ApiModelProperty(value = "答辩成绩， 取平均值")
    private Float score;
}
