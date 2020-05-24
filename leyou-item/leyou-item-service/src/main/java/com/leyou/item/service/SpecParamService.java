package com.leyou.item.service;

import com.leyou.item.pojo.SpecParam;

import java.util.List;

public interface SpecParamService {
    List<SpecParam> querySpecParamBySpcGid(Long gid);
}
