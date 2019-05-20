package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.common.base.select.SelectByPrimaryKeyMapper;


import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;//disable

    public List<Category> queryCategoryListByPid(Long pid){
        //查询条件
        Category t =new Category();
        t.setParentId(pid);
        //把对象的非空字段作为查询条件
        List<Category> list = categoryMapper.select(t);
        //判断结果
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnums.CATEGOTY_NOT_FOUND);
        }
        return list;
    }

    public List<Category> queryCategoryByIds(List<Long> ids) {
        return categoryMapper.selectByIdList(ids);

    }
}
