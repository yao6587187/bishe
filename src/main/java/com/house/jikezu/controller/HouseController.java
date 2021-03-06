package com.house.jikezu.controller;

import com.house.jikezu.model.House;
import com.house.jikezu.service.HouseService;
import com.house.jikezu.vo.ConditionHouseReturnVO;
import com.house.jikezu.vo.HouseListReturnVO;
import com.house.jikezu.vo.HouseListVo;
import com.house.jikezu.vo.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "房源接口")
@CrossOrigin
public class HouseController {

    @Resource
    HouseService houseService;

    @PostMapping("/addHouse")
    @ApiOperation("添加房源")
    public String add(@RequestBody House house){
        return houseService.addHouse(house);
    }

    @GetMapping("/getHouse")
    @ApiOperation("获取唯一房源")
    public House get(@RequestParam String houseNum){
        return houseService.getHouse(houseNum);
    }

    @GetMapping("/listHouses")
    @ApiOperation("获取我的房源")
    public PageData<List<House>> list(@RequestParam String userNum, @RequestParam Integer currentPage, @RequestParam Integer pageSize){
        return houseService.listHouses(userNum,currentPage,pageSize);
    }

    @PostMapping("/getConditionHouse")
    @ApiOperation("房源筛选")
    public ConditionHouseReturnVO getConditions(@RequestBody HouseListVo houseListVo){
        ConditionHouseReturnVO conditionHouseReturnVO = new ConditionHouseReturnVO();
        List<HouseListReturnVO> vos = houseService.selectHousesByPage(houseListVo,houseListVo.getCurrentPage(),houseListVo.getPageSize());
        if (vos==null){
            conditionHouseReturnVO.setFinished(false);
            return conditionHouseReturnVO;
        }
        conditionHouseReturnVO.setResultHouses(vos);
        return conditionHouseReturnVO;
    }

    @GetMapping("/deleteHouse")
    @ApiOperation("删除房源")
    public String delete(@RequestParam String houseNum){
        return houseService.deleteHouseByHouseNum(houseNum);
    }
}
