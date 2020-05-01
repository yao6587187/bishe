package com.house.jikezu.controller;


import com.house.jikezu.service.ContractRequestService;
import com.house.jikezu.vo.HouseContractRequestVO;
import com.house.jikezu.vo.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "合同请求")
@CrossOrigin
public class HouseContractRequestController {

    @Resource
    ContractRequestService contractRequestService;

    @ApiOperation("拒绝请求")
    @GetMapping("/rejectContractRequest")
    public String reject(@RequestParam String houseContractNum){
        return contractRequestService.rejectContractRequest(houseContractNum);
    }

    @ApiOperation("同意请求")
    @GetMapping("/agreeContractRequest")
    public String agree(@RequestParam String houseContractNum){
        return contractRequestService.agreeContractRequest(houseContractNum);
    }

    @ApiOperation("我的合同请求")
    @GetMapping("/listContractRequest")
    public PageData<List<HouseContractRequestVO>> list(@RequestParam String userNum,@RequestParam Integer currentPage, @RequestParam Integer pageSize){
        return contractRequestService.listContractRequest(userNum,currentPage,pageSize);
    }

}
