package com.house.jikezu.controller;

import com.house.jikezu.service.ReservationHouseService;
import com.house.jikezu.vo.ReservationListReturnVO;
import com.house.jikezu.vo.ReservationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/jikezhu")
@Api(tags = "预约房源")
@CrossOrigin
public class HouseReservationController {

    @Resource
    ReservationHouseService reservationHouseService;

    @PostMapping("/reservationHouse")
    @ApiOperation("预约")
    public String reservation(@RequestBody ReservationVO reservationVO) {
        return reservationHouseService.reservation(reservationVO);
    }

    @GetMapping("/listReservationHouse")
    @ApiOperation("我的预约")
    public List<ReservationListReturnVO> list(@RequestParam String landlordNum) {
        return reservationHouseService.listReservationHouses(landlordNum);
    }

    @GetMapping("/deleteReservationHouse")
    @ApiOperation("删除预约")
    public Integer deleteReservationHouse(@RequestParam String houseReservationNum) {
        return reservationHouseService.deleteByHouseReservationNum(houseReservationNum);
    }
}
