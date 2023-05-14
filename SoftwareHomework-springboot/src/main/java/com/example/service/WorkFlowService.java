package com.example.service;

import com.example.entity.WorkFlow;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface WorkFlowService {

    boolean findUserIsExist(Long id);
    boolean assuredSelfEvaluation(Long id);

    boolean assuredUserInfo(Long id);

    boolean assuredBlindReview(Long id);

    boolean findBlindReviewPreviewAssured(Long id);

    void insert(Long id);
    List<WorkFlow> findAllWorkFlow();

    boolean assuredDefenseApproval(Long id);

    boolean findDefenseApprovalPreviewAssured(Long id);

    boolean assuredBlindReviewResult(Long id);

    boolean assuredAllowDownload(Long id);

    boolean assuredApprovalResult(Long id);

    boolean assuredDefenseApprovalResult(Long id);

    boolean findDegreeApplicationPreviewAssured(Long id);

    boolean assuredDegreeApplication(Long id);

    WorkFlow findById(Long id);
}
