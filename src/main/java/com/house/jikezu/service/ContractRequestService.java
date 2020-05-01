package com.house.jikezu.service;

import com.house.jikezu.vo.HouseContractRequestVO;
import com.house.jikezu.vo.PageData;

import java.util.List;

public interface ContractRequestService {

    String sendContractRequest(String userNum,String houseContractNum,String requestType,Integer xuyueTime);

    //同意续约
    String agreeContractRequest(String houseContractNum);

    //拒绝续约
    String rejectContractRequest(String houseContractNum);

    PageData<List<HouseContractRequestVO>> listContractRequest(String userNum, Integer currentPage, Integer pageSize);

}
