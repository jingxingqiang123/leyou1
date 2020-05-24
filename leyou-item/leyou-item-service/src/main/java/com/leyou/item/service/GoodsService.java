package com.leyou.item.service;

import com.leyou.item.common.PageResult;
import com.leyou.item.pojo.bo.SpuBo;

public interface GoodsService {
    PageResult<SpuBo> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows);
}
