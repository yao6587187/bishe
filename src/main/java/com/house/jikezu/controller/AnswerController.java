package com.house.jikezu.controller;

import com.house.jikezu.model.Answer;
import com.house.jikezu.model.Question;
import com.house.jikezu.service.AnswerService;
import com.house.jikezu.vo.PageData;
import com.house.jikezu.vo.QuestionListReturnVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "回答接口")
@CrossOrigin
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/addAnswer")
    @ApiOperation("回答问题")
    @ApiParam(name = "answer", value = "回答对象：只需要answerContent，questionNum，userNum")
    public String addAnswer(@RequestBody Answer answer) {
        return answerService.addAnswer(answer);
    }

    @GetMapping("/deleteAnswer")
    @ApiOperation("删除问题")
    @ApiParam(name = "answerNum", value = "回答编号")
    public String deleteQuestion(@RequestParam String answerNum) {
        return answerService.deleteAnswerByAnswerNum(answerNum);
    }


    @ApiOperation("答案列表")
    @GetMapping("/listAnswerByQueNum")
    public PageData<List<Answer>> listAnswerByQueNum(@RequestParam String questionNum, @RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return answerService.listAnswerByQueNum(questionNum, currentPage, pageSize);
    }
}
