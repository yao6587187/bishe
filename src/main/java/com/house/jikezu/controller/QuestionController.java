package com.house.jikezu.controller;

import com.house.jikezu.model.Question;
import com.house.jikezu.service.QuestionService;
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
@Api(tags = "问题接口")
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    @ApiOperation("提问")
    @ApiParam(name = "question", value = "问题对象：questionContent，userNum")
    public String addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/deleteQuestion")
    @ApiOperation("删除问题")
    @ApiParam(name = "questionNum", value = "问题编号")
    public String deleteQuestion(@RequestParam String questionNum) {
        return questionService.deleteQuestion(questionNum);
    }


    @ApiOperation("问题列表")
    @GetMapping("/listAllQuestion")
    public PageData<List<QuestionListReturnVO>> listAllQuestion(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return questionService.listAllQuestion(currentPage, pageSize);
    }

}
