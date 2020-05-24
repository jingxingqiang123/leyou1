package com.leyou.item.controller;

import com.leyou.item.common.PageResult;
import com.leyou.item.pojo.bo.SpuBo;
import com.leyou.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spu")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

   //  http://api.leyou.com/api/item/spu/page?key=&saleable=true&page=1&rows=5
   //  http://api.leyou.com/api/item/spu/page?key=&saleable=true&page=1&rows=5
   //  http://api.leyou.com/api/item/spu/page?key=to&saleable=true&page=1&rows=5
    /**
     *  根据条件分类查询Spu
     * @param key 搜索条件
     * @param saleable 是否上下架
     * @param page 当前页
     * @param rows 页面大小
     * @return
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "saleable", required = false) Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ) {
        PageResult<SpuBo> pageResult = this.goodsService.querySpuByPage(key, saleable, page, rows);
        if (pageResult == null || CollectionUtils.isEmpty(pageResult.getItems())) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pageResult);
    }
}
