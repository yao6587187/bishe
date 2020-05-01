package com.house.jikezu.controller;

import com.house.jikezu.model.Info;
import com.house.jikezu.service.InfoService;
import com.house.jikezu.vo.ContractVO;
import com.house.jikezu.vo.InfoListReturnVO;
import com.house.jikezu.vo.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "资讯接口")
@CrossOrigin
public class InfoController {

    @Autowired
    private InfoService infoService;

    @PostMapping("/addInfo")
    @ApiOperation("发表资讯")
    @ApiParam(name = "info", value = "资讯对象：只需要传infoTitle，infoContent，userNum")
    public String addInfo(@RequestBody Info info) {
        return infoService.addInfo(info);
    }

    @GetMapping("/deleteInfo")
    @ApiOperation("删除资讯")
    @ApiParam(name = "infoNum", value = "资讯编号")
    public String deleteInfo(@RequestParam String infoNum) {
        return infoService.deleteInfo(infoNum);
    }

    @GetMapping("/getInfo")
    @ApiOperation("获取资讯详情")
    @ApiParam(name = "infoNum", value = "资讯编号")
    public Info getInfo(@RequestParam String infoNum) {
        return infoService.selectInfoByInfoNum(infoNum);
    }

    @ApiOperation("资讯列表")
    @GetMapping("/listAllInfo")
    public PageData<List<InfoListReturnVO>> listAllInfo(@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return infoService.listInfo(currentPage, pageSize);
    }
}
