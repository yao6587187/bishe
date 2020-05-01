package com.house.jikezu.service;

import com.house.jikezu.model.HouseContract;
import com.house.jikezu.vo.ContractInfoVO;
import com.house.jikezu.vo.ContractSingleVO;
import com.house.jikezu.vo.ContractVO;
import com.house.jikezu.vo.PageData;

import java.util.List;

public interface ContractHouseService {

    /**
     * 签约
     */
    String contract(ContractSingleVO contractSingleVO);


    /**
     * 我的合同
     */
    PageData<List<ContractVO>> getContractHouse(String userNum, Integer currentPage, Integer pageSize);

    /**
     * 查看合同
     */
    ContractInfoVO getContractInfo(String houseContractNum);

    /**
     * 续约
     *
     * @param houseContract
     * @return
     */
    Integer updateByPrimaryKeySelective(HouseContract houseContract);

    /**
     * 解约
     *
     * @param houseContractNum
     * @return
     */
    Integer deleteByPrimaryKey(String houseContractNum);
}
