package com.jayus.lioj.judge;

import com.jayus.lioj.judge.strategy.DefaultJudgeStrategy;
import com.jayus.lioj.judge.strategy.JavaLanguageJudgeStrategy;
import com.jayus.lioj.judge.strategy.JudgeContext;
import com.jayus.lioj.judge.strategy.JudgeStrategy;
import com.jayus.lioj.model.dto.questionsubmit.JudgeInfo;
import com.jayus.lioj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
