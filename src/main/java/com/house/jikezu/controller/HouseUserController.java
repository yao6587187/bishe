package com.house.jikezu.controller;


import com.house.jikezu.model.HouseUser;
import com.house.jikezu.service.HouseUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "用户接口")
@CrossOrigin
public class HouseUserController {

    @Resource
    HouseUserService houseUserService;

    @PostMapping("/createUser")
    @ApiOperation("添加用户")
    public HouseUser add(@RequestBody HouseUser houseUser){
        return houseUserService.createUser(houseUser);
    }

    @PostMapping("/updateUser")
    @ApiOperation("更新用户")
    public HouseUser update(@RequestBody HouseUser houseUser){
        return houseUserService.updateUser(houseUser);
    }
}
