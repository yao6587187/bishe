package com.house.jikezu.controller;


import com.house.jikezu.service.ContractHouseService;
import com.house.jikezu.service.ContractRequestService;
import com.house.jikezu.vo.ContractInfoVO;
import com.house.jikezu.vo.ContractSingleVO;
import com.house.jikezu.vo.ContractVO;
import com.house.jikezu.vo.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "房源合同")
@CrossOrigin
public class HouseContractController {

    @Resource
    ContractHouseService contractHouseService;

    @Resource
    ContractRequestService contractRequestService;

    @ApiOperation("生成合同")
    @PostMapping("/contractHouse")
    public String contract(@RequestBody ContractSingleVO contractSingleVO) {
        return contractHouseService.contract(contractSingleVO);
    }

    @ApiOperation("我的合同")
    @GetMapping("/listHouseContract")
    public PageData<List<ContractVO>> listContract(@RequestParam String userNum, @RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return contractHouseService.getContractHouse(userNum,currentPage,pageSize);
    }

    @ApiOperation("查看合同")
    @GetMapping("/readHouseContract")
    public ContractInfoVO read(@RequestParam String houseContractNum) {
        return contractHouseService.getContractInfo(houseContractNum);
    }

    @ApiOperation("续约")
    @PostMapping("/continueContract")
    public String continueContract(@RequestParam String userNum,@RequestParam String houseContractNum,@RequestParam String requestType,
                                   @RequestParam Integer xuyueTime) {
        return contractRequestService.sendContractRequest(userNum,houseContractNum,requestType,xuyueTime);
    }

    @ApiOperation("解约")
    @ApiParam(name = "houseContractNum", value = "合同编号")
    @GetMapping("/endContract")
    public String endContract(@RequestParam String userNum,@RequestParam String houseContractNum,@RequestParam String requestType,
                              @RequestParam Integer xuyueTime) {
        return contractRequestService.sendContractRequest(userNum,houseContractNum,requestType,xuyueTime);
    }

}
