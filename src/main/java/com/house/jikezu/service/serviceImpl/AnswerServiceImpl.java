package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.AnswerMapper;
import com.house.jikezu.model.Answer;
import com.house.jikezu.service.AnswerService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Resource
    private AnswerMapper answerMapper;

    @Override
    public String addAnswer(Answer answer) {
        answer.setAnswerNum(OrderUtil.getOrderNoByUUID("A"));
        answerMapper.insert(answer);
        return answer.getAnswerNum();
    }

    @Override
    public String deleteAnswerByAnswerNum(String answerNum) {
        answerMapper.deleteByPrimaryKey(answerNum);
        return answerNum;
    }

    @Override
    public String deleteAnswerByQuestionNum(String questionNum) {
        answerMapper.deleteByQuestionNum(questionNum);
        return questionNum;
    }

    @Override
    public PageData<List<Answer>> listAnswerByQueNum(String questionNum, Integer currentPage, Integer pageSize) {
        PageData<List<Answer>> pageData = new PageData<>();
        List<Answer> answers = answerMapper.listAnswerByQueNum(questionNum, (currentPage - 1) * pageSize, pageSize);

        pageData.setDatas(answers);
        pageData.setCurrentPage(currentPage);
        pageData.setPageSize(pageSize);
        if (pageData.getDatas() == null || pageData.getDatas().size() == 0) {
            pageData.setFinished(false);
        }

        return pageData;
    }
}
