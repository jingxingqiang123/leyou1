package com.leyou.item.controller;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecGroupService;
import com.leyou.item.service.SpecParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spec") //Request URL: http://api.leyou.com/api/item/spec/groups/76
public class SpecificationController {

    @Autowired
    private SpecGroupService specGroupService;

    @Autowired
    private SpecParamService specParamService;

    /**
     * 根据分类id,查询参数组
     *
     * @param cid 分类id
     * @return
     */
    @GetMapping("/groups/{cid}")//Request URL: http://api.leyou.com/api/item/spec/params?gid=1
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") Long cid) {
        if (cid == null || cid < 0) {
            return ResponseEntity.notFound().build();
        }
        List<SpecGroup> specGroupList = this.specGroupService.queryGroupByCid(cid);
        if (CollectionUtils.isEmpty(specGroupList)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specGroupList);
    }

    /**
     * 根据规格参数的组id,查询规格参数
     * @param gid
     * @return
     */
    @GetMapping("/params")//api.leyou.com/api/item/spec/params?gid=2
    public ResponseEntity<List<SpecParam>> querySpecParamBySpcGid(@RequestParam("gid") Long gid) {
        List<SpecParam> specParams = this.specParamService.querySpecParamBySpcGid(gid);
        if (CollectionUtils.isEmpty(specParams)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(specParams);
    }
}
