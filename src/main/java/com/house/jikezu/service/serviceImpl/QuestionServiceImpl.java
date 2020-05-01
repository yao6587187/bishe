package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseUserMapper;
import com.house.jikezu.dao.QuestionMapper;
import com.house.jikezu.model.HouseUser;
import com.house.jikezu.model.Question;
import com.house.jikezu.service.AnswerService;
import com.house.jikezu.service.QuestionService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.PageData;
import com.house.jikezu.vo.QuestionListReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private HouseUserMapper houseUserMapper;
    @Autowired
    private AnswerService answerService;

    @Override
    public String addQuestion(Question question) {
        question.setQuestionNum(OrderUtil.getOrderNoByUUID("Q"));
        questionMapper.insert(question);
        return question.getQuestionNum();
    }

    @Override
    public String deleteQuestion(String questionNum) {
        answerService.deleteAnswerByQuestionNum(questionNum);
        System.out.println("成功删除问题" + questionNum + "答案");
        questionMapper.deleteByPrimaryKey(questionNum);
        return questionNum;
    }

    @Override
    public PageData<List<QuestionListReturnVO>> listAllQuestion(Integer currentPage, Integer pageSize) {
        PageData<List<QuestionListReturnVO>> pageData = new PageData<>();

        List<Question> questions = questionMapper.listAllQuestion((currentPage - 1) * pageSize, pageSize);
        List<QuestionListReturnVO> questionListReturnVOS = new ArrayList<>();
        QuestionListReturnVO questionListReturnVO;
        //封装问题返回
        for (Question q : questions) {
            HouseUser houseUser = houseUserMapper.selectByPrimaryKey(q.getUserNum());

            questionListReturnVO = new QuestionListReturnVO();

            questionListReturnVO.setQuestionNum(q.getQuestionNum());
            questionListReturnVO.setUserId(houseUser.getUserId());
            questionListReturnVO.setQuestionContent(q.getQuestionContent());

            questionListReturnVOS.add(questionListReturnVO);
        }
        pageData.setDatas(questionListReturnVOS);
        pageData.setCurrentPage(currentPage);
        pageData.setPageSize(pageSize);
        if (pageData.getDatas() == null || pageData.getDatas().size() == 0) {
            pageData.setFinished(false);
        }

        return pageData;
    }
}
