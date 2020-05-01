package com.house.jikezu.service;

import com.house.jikezu.model.Question;
import com.house.jikezu.vo.PageData;
import com.house.jikezu.vo.QuestionListReturnVO;

import java.util.List;

public interface QuestionService {

    /**
     * 添加问题
     *
     * @param question
     * @return
     */
    String addQuestion(Question question);

    /**
     * 删除问题
     *
     * @param questionNum
     * @return
     */
    String deleteQuestion(String questionNum);


    /**
     * 问题列表
     *
     * @return
     */
    PageData<List<QuestionListReturnVO>> listAllQuestion(Integer currentPage, Integer pageSize);
}
