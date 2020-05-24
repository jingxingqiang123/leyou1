package com.leyou.item.service.impl;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper CategoryMapper;

    /**
     * 根据父节点，查询子节点
     *
     * @param pid 父节点的id
     * @return
     */
    @Override
    public List<Category> queryCategoryListByParentId(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return this.CategoryMapper.select(category);
    }

    /**
     * 根据分类id获取分类名字
     *
     * @param ids
     */
    @Override
    public List<String> queryCategoryNameByCid(List<Long> ids) {
        List<Category> categories = this.CategoryMapper.selectByIdList(ids);
        return categories.stream().map(category -> category.getName()).collect(Collectors.toList());
    }

}
