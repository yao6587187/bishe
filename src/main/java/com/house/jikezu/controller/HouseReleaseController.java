package com.house.jikezu.controller;

import com.house.jikezu.model.House;
import com.house.jikezu.service.ReleaseHouseService;
import com.house.jikezu.vo.PageData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "发布房源")
@CrossOrigin
public class HouseReleaseController {

    @Resource
    private ReleaseHouseService releaseHouseService;

    @GetMapping("/releaseHouse")
    @ApiOperation("发布")
    public String release(@RequestParam String houseNum, @RequestParam String landlordNum) {
        return releaseHouseService.release(houseNum, landlordNum);
    }

    @GetMapping("/listReleaseHouses")
    @ApiOperation("我的发布")
    public PageData<List<House>> list(@RequestParam String landlordNum, @RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        return releaseHouseService.listReleaseHouses(landlordNum,currentPage,pageSize);
    }
}
