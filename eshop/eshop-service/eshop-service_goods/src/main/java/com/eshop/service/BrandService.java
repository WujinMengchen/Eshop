package com.eshop.service;

import com.eshop.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface BrandService {

    List<Brand> findAll();
    Brand findById(Integer id);

    List<Brand> findList(Brand brand);
    PageInfo<Brand> findPage(Integer page, Integer size);
    PageInfo<Brand> findPage(Integer page, Integer size, Brand brand);
}
