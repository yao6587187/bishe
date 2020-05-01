package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseContractMapper;
import com.house.jikezu.dao.HouseContractRequestMapper;
import com.house.jikezu.dao.HouseMapper;
import com.house.jikezu.dao.HouseUserMapper;
import com.house.jikezu.model.House;
import com.house.jikezu.model.HouseContract;
import com.house.jikezu.model.HouseContractRequest;
import com.house.jikezu.model.HouseUser;
import com.house.jikezu.service.ContractHouseService;
import com.house.jikezu.service.ContractRequestService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.HouseContractRequestVO;
import com.house.jikezu.vo.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ContractRequestServiceImpl implements ContractRequestService {

    @Resource
    HouseContractRequestMapper houseContractRequestMapper;

    @Resource
    ContractHouseService contractHouseService;

    @Resource
    HouseContractMapper houseContractMapper;

    @Resource
    HouseUserMapper houseUserMapper;

    @Resource
    HouseMapper houseMapper;

    @Override
    public String sendContractRequest(String userNum,String houseContractNum,String requestType,Integer xuyueTime) {
        HouseContractRequest houseContractRequest = new HouseContractRequest();
        HouseContract houseContract = houseContractMapper.selectByPrimaryKey(houseContractNum);
        if (houseContract.getHouseTenantNum().equals(userNum)){
            houseContractRequest.setTenantNum(houseContract.getHouseTenantNum());
            houseContractRequest.setLandlordNum(houseContract.getHouseLandlordNum());
        }else{
            houseContractRequest.setTenantNum(houseContract.getHouseLandlordNum());
            houseContractRequest.setLandlordNum(houseContract.getHouseTenantNum());
        }
        houseContractRequest.setRequestType(requestType);
        houseContractRequest.setContractRequestNum(OrderUtil.getOrderNoByUUID("Q"));
        houseContractRequest.setHouseContractNum(houseContractNum);
        houseContractRequest.setXuyuetime(xuyueTime);
        houseContractRequestMapper.insert(houseContractRequest);
        return houseContractRequest.getContractRequestNum();
    }

    @Override
    public String agreeContractRequest(String houseContractNum) {
        HouseContract houseContract = houseContractMapper.selectByPrimaryKey(houseContractNum);
        HouseContractRequest request = houseContractRequestMapper.selectByPrimaryKey(houseContractNum);
        if (request.getRequestType().equals("jieyue")){
            contractHouseService.deleteByPrimaryKey(houseContractNum);
            houseContractRequestMapper.deleteByPrimaryKey(houseContractNum);
        }else{
            houseContract.setDurationMonth(request.getXuyuetime());
            contractHouseService.updateByPrimaryKeySelective(houseContract);
            houseContractRequestMapper.deleteByPrimaryKey(houseContractNum);
        }
        return houseContract.getHouseContractNum();
    }

    @Override
    public String rejectContractRequest(String houseContractNum) {
        houseContractRequestMapper.deleteByPrimaryKey(houseContractNum);
        return houseContractNum;
    }

    @Override
    public PageData<List<HouseContractRequestVO>> listContractRequest(String userNum, Integer currentPage, Integer pageSize) {
        PageData<List<HouseContractRequestVO>> pageData = new PageData<>();
        List<HouseContractRequest> houseContractRequests = houseContractRequestMapper.getHouseContractRequestByLandlordNumPage(
                userNum, (currentPage-1)*pageSize,pageSize);
        List<HouseContractRequestVO> houseContractRequestVOS = new ArrayList<>();
        HouseContractRequestVO houseContractRequestVO;
        for (HouseContractRequest request:houseContractRequests
             ) {
            houseContractRequestVO = new HouseContractRequestVO();
            HouseContract houseContract = houseContractMapper.selectByPrimaryKey(request.getHouseContractNum());
            HouseUser tenant = houseUserMapper.selectByPrimaryKey(houseContract.getHouseTenantNum());
            House house = houseMapper.selectByPrimaryKey(houseContract.getHouseNum());
            houseContractRequestVO.setRequestPersonName(tenant.getUserName());
            houseContractRequestVO.setHouseContractNum(houseContract.getHouseContractNum());
            houseContractRequestVO.setRequestType(getRequestType(request.getRequestType(),request.getXuyuetime()));
            houseContractRequestVO.setContractRequestNum(request.getContractRequestNum());
            houseContractRequestVO.setContractExpireDate(
                    stepMonth(houseContract.getContraceEffectiveDate(),houseContract.getDurationMonth()));
            houseContractRequestVO.setHouseAddress(house.getProvince() + house.getCity() + house.getRegion() +
                    "{" + house.getDescAddress() + "}" + house.getBuilding() + "栋" + house.getUnit() + "单元");
            houseContractRequestVOS.add(houseContractRequestVO);
        }
        pageData.setDatas(houseContractRequestVOS);
        if (pageData.getDatas() == null || pageData.getDatas().size() == 0){
            pageData.setFinished(false);
        }
        pageData.setCurrentPage(currentPage);
        pageData.setPageSize(pageSize);
        return pageData;
    }

    private String getRequestType(String requestType,Integer monthNum){
        if (requestType.equals("xuyue")){
            return "续约"+monthNum+"个月";
        }else {
            return "解约";
        }
    }

    private Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

}
