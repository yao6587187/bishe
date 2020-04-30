package com.house.jikezu.controller;

import com.house.jikezu.model.House;
import com.house.jikezu.service.HouseService;
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
    public List<House> list(@RequestParam String userNum){
        return houseService.listHouses(userNum);
    }
}
