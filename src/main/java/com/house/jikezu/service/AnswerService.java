package com.house.jikezu.service;

import com.house.jikezu.model.Answer;
import com.house.jikezu.vo.PageData;

import java.util.List;

public interface AnswerService {

    /**
     * 添加回答
     *
     * @param answer
     * @return
     */
    String addAnswer(Answer answer);

    /**
     * 根据回答编号删除回答
     *
     * @param answerNum
     * @return
     */
    String deleteAnswerByAnswerNum(String answerNum);

    /**
     * 根据问题编号删除回答
     *
     * @param questionNum
     * @return
     */
    String deleteAnswerByQuestionNum(String questionNum);

    /**
     * 根据问题编号查询回答列表
     *
     * @param questionNum
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageData<List<Answer>> listAnswerByQueNum(String questionNum, Integer currentPage, Integer pageSize);
}
