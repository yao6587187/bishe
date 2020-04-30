package com.house.jikezu.controller;


import com.house.jikezu.model.HouseContract;
import com.house.jikezu.service.ContractHouseService;
import com.house.jikezu.vo.ContractInfoVO;
import com.house.jikezu.vo.ContractSingleVO;
import com.house.jikezu.vo.ContractVO;
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

    @ApiOperation("生成合同")
    @PostMapping("/contractHouse")
    public String contract(@RequestBody ContractSingleVO contractSingleVO) {
        return contractHouseService.contract(contractSingleVO);
    }

    @ApiOperation("我的合同")
    @GetMapping("/listHouseContract")
    public List<ContractVO> listContract(@RequestParam String userNum) {
        return contractHouseService.getContractHouse(userNum);
    }

    @ApiOperation("查看合同")
    @GetMapping("/readHouseContract")
    public ContractInfoVO read(@RequestParam String houseContractNum) {
        return contractHouseService.getContractInfo(houseContractNum);
    }

    @ApiOperation("续约")
    @PostMapping("/continueContract")
    public Integer continueContract(@RequestBody HouseContract houseContract) {
        return contractHouseService.updateByPrimaryKeySelective(houseContract);
    }

    @ApiOperation("解约")
    @ApiParam(name = "houseContractNum", value = "合同编号")
    @GetMapping("/endContract")
    public Integer endContract(@RequestParam String houseContractNum) {
        return contractHouseService.deleteByPrimaryKey(houseContractNum);
    }

}
