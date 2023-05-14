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
 * 工作流程表
 */
@Table
@Data
@ToString
@ApiModel(value = "工作流程表")
public class WorkFlow {
    @Column(name = "id", isKey = true, type = MySqlTypeConstant.BIGINT)
    @ApiModelProperty(value = "学号")
    @Id
    private Long id;

    // 学位论文预审
    // 默认已经完成
    //@Column(name = "pretrial", type = MySqlTypeConstant.TINYINT, defaultValue = "2")
    //@ApiModelProperty(value = "学位论文预审", notes = "已完成为2，未完成为1，默认已完成")
    //private Integer pretrial;

    // 预毕业信息确认
    @Column(name = "user_info", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "预毕业信息确认", notes = "已完成为2，未完成为1，默认未完成")
    private Integer userInfo;

    // 个人信息核对、课程审核
    // 暂时不关注
    // @Column(name = "review", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    // @ApiModelProperty(value = "个人信息核对、课程审核", notes = "已完成为2，未完成为1，默认未完成")
    // private Integer review;

    // 自评论文预审
    @Column(name = "self_evaluation", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "自评论文预审", notes = "已完成为2，未完成为1，默认未完成")
    private Integer selfEvaluation;

    // 盲审
    @Column(name = "blind_review", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "盲审", notes = "已完成为2，未完成为1，默认未完成")
    private Integer blindReview;

    // 评阅答辩审批
    @Column(name = "defense_approval", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "评阅答辩审批", notes = "已完成为2，未完成为1，默认未完成")
    private Integer defenseApproval;

    // 开放答辩材料下载
    @Column(name = "allow_download", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "开放答辩材料下载", notes = "已完成为2，未完成为1，默认未完成")
    private Integer allowDownload;

    // 盲审评阅总评
    @Column(name = "blind_review_result", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "盲审评阅总评", notes = "已完成为2，未完成为1，默认未完成")
    private Integer blindReviewResult;

    // 答辩成绩提交
    @Column(name = "score_submission", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "答辩成绩提交", notes = "已完成为2，未完成为1，默认未完成")
    private Integer scoreSubmission;

    // 学位申请
    @Column(name = "degree_application", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "学位申请", notes = "已完成为2，未完成为1，默认未完成")
    private Integer degreeApplication;

    // 审批、查看审批结果
    @Column(name = "approval_result", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    @ApiModelProperty(value = "审批、查看学位审批结果", notes = "已完成为2，未完成为1，默认未完成")
    private Integer approvalResult;

}
