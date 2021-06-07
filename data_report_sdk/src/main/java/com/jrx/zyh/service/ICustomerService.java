package com.jrx.zyh.service;

import com.jrx.zyh.model.Customer;
import com.jrx.zyh.model.enums.PageInfo;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 16:22
 * @describe
 */
public interface ICustomerService {

    void addOne(Customer customer);

    List<Customer> findAll();

    PageInfo<Customer> findCustomerByCondition(Integer pageNum, String name, Integer custId);
}
