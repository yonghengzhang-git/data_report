package com.jrx.zyh.web.controller;

import com.jrx.zyh.model.Customer;
import com.jrx.zyh.model.Result;
import com.jrx.zyh.model.enums.PageInfo;
import com.jrx.zyh.service.ICustomerService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 15:22
 * @describe
 */
@RestController
@ApiModel("查询客户相关信息")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping(value = {"/customer/find/{pageNum}/{name}/{custId}","/customer/find/{pageNum}"})
    public Result<PageInfo<Customer>> findCustomer(
            @ApiParam(value = "页码",required = true)
            @PathVariable(value = "pageNum",required = true)Integer pageNum,
            @ApiParam("客户姓名")
            @PathVariable(value = "name",required = false)String name,
            @ApiParam("客户id")
            @PathVariable(value = "custId",required = false)Integer custId){
        Long start = System.currentTimeMillis();

        PageInfo<Customer> pageInfo = customerService.findCustomerByCondition(pageNum,name,custId);

        Result<PageInfo<Customer>> result = new Result<>();
        result.setCode(201);
        result.setData(pageInfo);
        result.setTimestamp(System.currentTimeMillis());
        result.setMessage("成功");
        result.setDuration(System.currentTimeMillis()-start);

        return result;
    }

}
