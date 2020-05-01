package com.house.jikezu.dao;

import com.house.jikezu.model.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);

    int deleteByQuestionNum(String questionNum);

    List<Answer> listAnswerByQueNum(String questionNum, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    List<Answer> listAllAnswer(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}