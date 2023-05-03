package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

/**
 * 工作流程表
 */
@Table
@Data
@ToString
public class WorkFlow {
    @Column(name = "id", isKey = true, type = MySqlTypeConstant.BIGINT)
    private Long id;

    // 学位论文预审
    // 默认已经完成
    @Column(name = "pretrial", type = MySqlTypeConstant.TINYINT, defaultValue = "2")
    private Integer pretrial;

    // 预毕业信息确认
    @Column(name = "confirmInfo", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer confirmInfo;

    // 个人信息核对、课程审核
    @Column(name = "review", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer review;

    // 自评论文预审
    @Column(name = "selfEvaluation", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer selfEvaluation;

    // 盲审
    @Column(name = "blindTrial", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer blindTrial;

    // 评阅答辩审批
    @Column(name = "defenseApproval", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer defenseApproval;

    // 盲审评阅总评
    @Column(name = "reviewSummary", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer reviewSummary;

    // 开放答辩材料下载
    @Column(name = "allowDownload", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer allowDownload;

    // 答辩成绩提交
    @Column(name = "scoreSubmission", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer scoreSubmission;

    // 学位申请
    @Column(name = "degreeApplication", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer degreeApplication;

    // 审批、查看审批结果
    @Column(name = "approvalResult", type = MySqlTypeConstant.TINYINT, defaultValue = "1")
    private Integer approvalResult;

}
