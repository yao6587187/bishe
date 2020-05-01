package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.dao.HouseReservationMapper;
import com.house.jikezu.dao.HouseUserMapper;
import com.house.jikezu.model.House;
import com.house.jikezu.model.HouseReservation;
import com.house.jikezu.model.HouseUser;
import com.house.jikezu.service.ReservationHouseService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.ReservationListReturnVO;
import com.house.jikezu.vo.ReservationVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationHouseServiceImpl implements ReservationHouseService {

    @Resource
    private HouseReservationMapper houseReservationMapper;

    @Resource
    private HouseMapper houseMapper;

    @Resource
    private HouseUserMapper houseUserMapper;



    @Override
    public String reservation(ReservationVO reservationVO) {
        HouseReservation houseReservation = new HouseReservation();
        houseReservation.setHouseReservationNum(OrderUtil.getOrderNoByUUID("Y"));
        houseReservation.setReservationTenantNum(reservationVO.getTenantNum());
        houseReservation.setReservationLandlordNum(reservationVO.getLandlordNum());
        houseReservation.setReservationDate(reservationVO.getReservationDate());
        houseReservation.setReservationHouseNum(reservationVO.getHouseNum());
        houseReservationMapper.insert(houseReservation);
        return houseReservation.getHouseReservationNum();
    }

    @Override
    public List<ReservationListReturnVO> listReservationHouses(String landlordNum) {
        List<HouseReservation> houseReservations = houseReservationMapper.listReservations(landlordNum);
        List<ReservationListReturnVO> reservationListReturnVOs = new ArrayList<>();
        ReservationListReturnVO reservationListReturnVO;
        for (HouseReservation houseReservation : houseReservations) {
            House house = houseMapper.selectByPrimaryKey(houseReservation.getReservationHouseNum());
            HouseUser tenant = houseUserMapper.selectByPrimaryKey(houseReservation.getReservationTenantNum());
            reservationListReturnVO = new ReservationListReturnVO();

            reservationListReturnVO.setHouseReservationNum(houseReservation.getHouseReservationNum());
            reservationListReturnVO.setHouseAddress(house.getProvince() + house.getCity() + house.getRegion()
                    + house.getDescAddress() + house.getBuilding() + "栋第" + house.getFloor() + "层" + house.getUnit() + "单元");
            reservationListReturnVO.setReservationUserName(tenant.getUserName());
            reservationListReturnVO.setReservationUserMobile(tenant.getPhoneNum());
            reservationListReturnVO.setReservationDate(houseReservation.getReservationDate());
            reservationListReturnVO.setReservationUserNum(tenant.getUserNum());
            reservationListReturnVOs.add(reservationListReturnVO);
        }
        return reservationListReturnVOs;
    }

    @Override
    public Integer deleteByHouseReservationNum(String houseReservationNum) {
        return houseReservationMapper.deleteByHouseReservationNum(houseReservationNum);
    }
}
