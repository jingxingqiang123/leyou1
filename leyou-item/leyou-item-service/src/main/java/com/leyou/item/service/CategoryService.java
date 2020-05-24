package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    List<Category> queryCategoryListByParentId(Long pid);

    List<String> queryCategoryNameByCid(List<Long> asList);
}
