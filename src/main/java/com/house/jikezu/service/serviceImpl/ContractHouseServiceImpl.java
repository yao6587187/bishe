package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseContractMapper;
import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.dao.HouseReservationMapper;
import com.house.jikezu.dao.HouseUserMapper;
import com.house.jikezu.enums.HouseStatusEnum;
import com.house.jikezu.model.House;
import com.house.jikezu.model.HouseContract;
import com.house.jikezu.model.HouseReservation;
import com.house.jikezu.model.HouseUser;
import com.house.jikezu.service.ContractHouseService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.ContractInfoVO;
import com.house.jikezu.vo.ContractSingleVO;
import com.house.jikezu.vo.ContractVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContractHouseServiceImpl implements ContractHouseService {

    @Resource
    HouseContractMapper houseContractMapper;

    @Resource
    HouseUserMapper houseUserMapper;

    @Resource
    HouseMapper houseMapper;

    @Resource
    HouseReservationMapper houseReservationMapper;

    @Override
    public String contract(ContractSingleVO contractSingleVO) {
        HouseContract houseContract = new HouseContract();
        HouseReservation houseReservation = houseReservationMapper.selectByPrimaryKey(contractSingleVO.getHouseReservationNum());
        houseContract.setDurationMonth(contractSingleVO.getMonth());
        houseContract.setContraceEffectiveDate(contractSingleVO.getEffectDate());
        houseContract.setHouseNum(houseReservation.getReservationHouseNum());
        houseContract.setHouseTenantNum(contractSingleVO.getTenantNum());
        houseContract.setHouseLandlordNum(contractSingleVO.getLandlordNum());
        houseContract.setHouseContractNum(OrderUtil.getOrderNoByUUID("C"));
        //插入合同数据
        houseContractMapper.insert(houseContract);
        House house = houseMapper.selectByPrimaryKey(houseReservation.getReservationHouseNum());
        house.setStatus(HouseStatusEnum.RENTED.getHouseStatus());
        //更新房源信息为已租
        houseMapper.updateByPrimaryKey(house);
        //删除预约表记录
        houseReservationMapper.deleteByReservationHouseNum(house.getHouseNum());
        //删除发布记录
        houseReservationMapper.deleteByReservationHouseNum(house.getHouseNum());
        return houseContract.getHouseContractNum();
    }

    @Override
    public List<ContractVO> getContractHouse(String userNum) {
        List<HouseContract> houseContracts = houseContractMapper.listHouseContract(userNum);
        List<ContractVO> contractVOS = new ArrayList<>();
        for (HouseContract houseContract : houseContracts
        ) {
            ContractVO contractVO = new ContractVO();
            HouseUser telnant = houseUserMapper.selectByPrimaryKey(houseContract.getHouseTenantNum());
            HouseUser landlord = houseUserMapper.selectByPrimaryKey(houseContract.getHouseLandlordNum());
            House house = houseMapper.selectByPrimaryKey(houseContract.getHouseNum());
            contractVO.setContractNum(houseContract.getHouseContractNum());
            contractVO.setEffectTime(houseContract.getContraceEffectiveDate());
            contractVO.setMonthNum(houseContract.getDurationMonth());
            contractVO.setTenantName(telnant.getUserName());
            contractVO.setLandlordName(landlord.getUserName());
            contractVO.setHouseTenantNum(telnant.getUserNum());
            contractVO.setHouseLandlordNum(landlord.getUserNum());
            contractVO.setHouseNum(house.getHouseNum());
            String descAddress = house.getProvince() + house.getCity() + house.getRegion() +
                    "{" + house.getDescAddress() + "}" + house.getBuilding() + "栋" + house.getUnit() + "单元";
            contractVO.setHouseAddress(descAddress);
            contractVOS.add(contractVO);
        }
        return contractVOS;
    }

    @Override
    public ContractInfoVO getContractInfo(String houseContractNum) {
        ContractInfoVO infoVO = new ContractInfoVO();
        HouseContract houseContract = houseContractMapper.selectByPrimaryKey(houseContractNum);
        HouseUser telnant = houseUserMapper.selectByPrimaryKey(houseContract.getHouseTenantNum());
        HouseUser landlord = houseUserMapper.selectByPrimaryKey(houseContract.getHouseLandlordNum());
        House house = houseMapper.selectByPrimaryKey(houseContract.getHouseNum());
        infoVO.setArea(house.getArea());
        infoVO.setBeginDate(houseContract.getContraceEffectiveDate());
        infoVO.setBuildings(house.getBuilding());
        infoVO.setCity(house.getCity());
        infoVO.setLandlordIdNum(landlord.getIdNum());
        infoVO.setLandlordPhoneNum(landlord.getPhoneNum());
        infoVO.setRegin(house.getRegion());
        infoVO.setEndDate(stepMonth(houseContract.getContraceEffectiveDate(), houseContract.getDurationMonth()));
        infoVO.setTelnantIdNum(telnant.getIdNum());
        infoVO.setTelnantName(telnant.getUserName());
        infoVO.setTelnantPhontNum(telnant.getPhoneNum());
        infoVO.setProvince(house.getProvince());
        infoVO.setUnit(house.getUnit());
        infoVO.setLandlordName(landlord.getUserName());
        return infoVO;
    }

    @Override
    public Integer updateByPrimaryKeySelective(HouseContract houseContract) {
        if (null == houseContract || StringUtils.isBlank(houseContract.getHouseContractNum()) || null == houseContract.getDurationMonth()) {
            return -1;
        }
        Integer oldMonth = houseContractMapper.selectByPrimaryKey(houseContract.getHouseContractNum()).getDurationMonth();
        Integer newMonth = oldMonth + houseContract.getDurationMonth();
        houseContract.setDurationMonth(newMonth);

        return houseContractMapper.updateByPrimaryKeySelective(houseContract);
    }

    @Override
    public Integer deleteByPrimaryKey(String houseContractNum) {
        if (StringUtils.isBlank(houseContractNum)) {
            return -1;
        }
        return houseContractMapper.deleteByPrimaryKey(houseContractNum);
    }

    public Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }
}
