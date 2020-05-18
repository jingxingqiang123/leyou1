package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService CategoryService;

    /**
     * 根据父节点的id,查询子节点
     * @param pid 父节点的id,为0为顶级类目，第一级类目
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryCategoryListByParentId(@RequestParam(value = "pid",defaultValue = "0")Long pid){
       if (pid == null ||pid < 0){
           // pid为null或者小于等于0，响应400
           // return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
           // return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           return ResponseEntity.badRequest().build();
       }
        List<Category> categoryList =  this.CategoryService.queryCategoryListByParentId(pid);
        // 判断集合是否为空
       if (CollectionUtils.isEmpty(categoryList)){
           // 404 资源服务器为资源服务器未找到
           // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           return ResponseEntity.notFound().build();
       }
        // 响应200 查询成功
       return ResponseEntity.ok(categoryList);
    }
}
