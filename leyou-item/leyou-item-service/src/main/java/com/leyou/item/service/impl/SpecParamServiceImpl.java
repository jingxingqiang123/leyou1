package com.leyou.item.service.impl;

import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecParamServiceImpl implements SpecParamService {
    @Autowired
    private SpecParamMapper specParamMapper;

    /**
     * 根据规格参数的组id,查询规格参数
     *
     * @param gid
     * @return
     */
    @Override
    public List<SpecParam> querySpecParamBySpcGid(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        return this.specParamMapper.select(specParam);

    }
}
