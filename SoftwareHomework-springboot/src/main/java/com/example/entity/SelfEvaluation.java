package com.example.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.ToString;

/**
 * 自评论文预审表
 */
@Data
@ToString
@Table
public class SelfEvaluation {
    @Column(name = "id", type = MySqlTypeConstant.BIGINT, isKey = true)
    private Long id;

    // 论文题目
    @Column(name = "title", type = MySqlTypeConstant.VARCHAR, length = 50)
    private String title;

    // 摘要
    @Column(name = "summary", type = MySqlTypeConstant.VARCHAR, length = 300)
    private String summary;

    // 自我评价
    @Column(name = "selfReview", type = MySqlTypeConstant.VARCHAR, length = 300)
    private String selfReview;

}
