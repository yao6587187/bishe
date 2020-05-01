package com.house.jikezu.dao;


import com.house.jikezu.model.Question;
import com.house.jikezu.vo.QuestionListReturnVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(String questionNum);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String questionNum);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> listAllQuestion(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}