package com.eshop.controller;

import com.eshop.goods.pojo.Brand;
import com.eshop.service.BrandService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public Result<List<Brand>> findAll() {
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"success!",brands);
    }
    /**
     *  //根据品牌的主键查询品牌的数据返回
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Brand>  findById(@PathVariable(name="id") Integer id){
        Brand brand =   brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"查询品牌成功",brand);
    }




    /**
     *
     * @param brand
     * @return
     */
    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody  Brand brand){
        List<Brand> brands =  brandService.findList(brand);
        return new Result(true,StatusCode.OK,"条件查询成功",brands);
    }

    /**
     *  分页查询
     * @param page 当前页
     * @param size 每页显示的行
     * @return
     */
    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value="page")Integer page,@PathVariable(value="size") Integer size){
        PageInfo<Brand> info = brandService.findPage(page,size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",info);
    }

    /**
     * 根据条件 来分页查询
     * @param page
     * @param size
     * @param brand 添加对象(请求体)
     * @return
     */
    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value="page")Integer page,@PathVariable(value="size") Integer size,@RequestBody  Brand brand){
        PageInfo<Brand> info = brandService.findPage(page,size,brand);
        int i=1/0;
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",info);
    }
}
