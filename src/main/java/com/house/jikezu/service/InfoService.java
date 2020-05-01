package com.house.jikezu.service;

import com.house.jikezu.model.Info;
import com.house.jikezu.vo.InfoListReturnVO;
import com.house.jikezu.vo.PageData;

import java.util.List;

public interface InfoService {

    /**
     * 添加资讯
     *
     * @param info
     * @return
     */
    String addInfo(Info info);

    /**
     * 删除资讯
     *
     * @param infoNum
     * @return
     */
    String deleteInfo(String infoNum);

    /**
     * 资讯详情
     */
    Info selectInfoByInfoNum(String infoNum);

    /**
     * 资讯列表
     *
     * @return
     */
    PageData<List<InfoListReturnVO>> listInfo(Integer currentPage, Integer pageSize);

    /**
     * 我的资讯
     *
     * @param userNum
     * @return
     */
    PageData<List<InfoListReturnVO>> listMyInfo(String userNum, Integer currentPage, Integer pageSize);
}
