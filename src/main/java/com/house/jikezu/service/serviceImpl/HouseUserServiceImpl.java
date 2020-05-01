package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseUserMapper;
import com.house.jikezu.model.HouseUser;
import com.house.jikezu.service.HouseUserService;
import com.house.jikezu.util.OrderUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HouseUserServiceImpl implements HouseUserService {

    @Resource
    HouseUserMapper houseUserMapper;

    @Override
    public HouseUser createUser(HouseUser houseUser) {
        houseUser.setUserNum(OrderUtil.getOrderNoByUUID("U"));
        houseUserMapper.insert(houseUser);
        houseUser = houseUserMapper.selectByPrimaryKey(houseUser.getUserNum());
        return houseUser;
    }

    @Override
    public HouseUser updateUser(HouseUser houseUser) {
        houseUserMapper.updateByPrimaryKeySelective(houseUser);
        return houseUserMapper.selectByPrimaryKey(houseUser.getUserNum());
    }
}
