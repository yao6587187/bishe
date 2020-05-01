package com.house.jikezu.service.serviceImpl;

import com.house.jikezu.dao.HouseUserMapper;
import com.house.jikezu.dao.InfoMapper;
import com.house.jikezu.model.HouseUser;
import com.house.jikezu.model.Info;
import com.house.jikezu.service.InfoService;
import com.house.jikezu.util.OrderUtil;
import com.house.jikezu.vo.ContractVO;
import com.house.jikezu.vo.InfoListReturnVO;
import com.house.jikezu.vo.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Resource
    private InfoMapper infoMapper;
    @Resource
    private HouseUserMapper houseUserMapper;

    @Override
    public String addInfo(Info info) {
        info.setInfoNum(OrderUtil.getOrderNoByUUID("I"));
        infoMapper.insert(info);
        return info.getInfoNum();
    }

    @Override
    public String deleteInfo(String infoNum) {
        infoMapper.deleteByPrimaryKey(infoNum);
        return infoNum;
    }

    @Override
    public Info selectInfoByInfoNum(String infoNum) {
        return infoMapper.selectByPrimaryKey(infoNum);
    }

    @Override
    public PageData<List<InfoListReturnVO>> listInfo(Integer currentPage, Integer pageSize) {
        PageData<List<InfoListReturnVO>> pageData = new PageData<>();

        List<Info> infos = infoMapper.listAllInfo((currentPage - 1) * pageSize, pageSize);
        List<InfoListReturnVO> infoListReturnVOS = new ArrayList<>();
        InfoListReturnVO infoListReturnVO;
        //封装返回对象
        for (Info info : infos) {
            HouseUser houseUser = houseUserMapper.selectByPrimaryKey(info.getUserNum());
            infoListReturnVO = new InfoListReturnVO();

            infoListReturnVO.setInfoNum(info.getInfoNum());
            infoListReturnVO.setUserId(houseUser.getUserId());
            infoListReturnVO.setInfoTitle(info.getInfoTitle());

            infoListReturnVOS.add(infoListReturnVO);
        }
        pageData.setDatas(infoListReturnVOS);
        pageData.setCurrentPage(currentPage);
        pageData.setPageSize(pageSize);
        if (pageData.getDatas() == null || pageData.getDatas().size() == 0) {
            pageData.setFinished(false);
        }
        return pageData;
    }

    @Override
    public PageData<List<InfoListReturnVO>> listMyInfo(String userNum, Integer currentPage, Integer pageSize) {
        PageData<List<InfoListReturnVO>> pageData = new PageData<>();

        List<Info> infos = infoMapper.listMyInfo(userNum, (currentPage - 1) * pageSize, pageSize);
        List<InfoListReturnVO> infoListReturnVOS = new ArrayList<>();
        InfoListReturnVO infoListReturnVO;
        //封装返回对象
        for (Info info : infos) {
            HouseUser houseUser = houseUserMapper.selectByPrimaryKey(info.getUserNum());
            infoListReturnVO = new InfoListReturnVO();

            infoListReturnVO.setInfoNum(info.getInfoNum());
            infoListReturnVO.setUserId(houseUser.getUserId());
            infoListReturnVO.setInfoTitle(info.getInfoTitle());

            infoListReturnVOS.add(infoListReturnVO);
        }

        pageData.setDatas(infoListReturnVOS);
        pageData.setCurrentPage(currentPage);
        pageData.setPageSize(pageSize);
        if (pageData.getDatas() == null || pageData.getDatas().size() == 0) {
            pageData.setFinished(false);
        }

        return pageData;
    }
}
