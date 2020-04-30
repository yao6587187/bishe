package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.model.House;
import com.house.jikezu.service.HouseService;
import com.house.jikezu.util.OrderUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseMapper houseMapper;

    @Override
    public String addHouse(House house) {
        house.setHouseNum(OrderUtil.getOrderNoByUUID("H"));
        houseMapper.insert(house);
        return house.getHouseNum();
    }

    @Override
    public List<House> listHouses(String userNum) {
        return houseMapper.listHouses(userNum);
    }

    @Override
    public House getHouse(String houseNum) {
        return houseMapper.selectByPrimaryKey(houseNum);
    }
}
