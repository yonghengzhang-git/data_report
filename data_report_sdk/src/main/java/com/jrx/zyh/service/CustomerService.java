package com.jrx.zyh.service;

import com.jrx.zyh.model.Customer;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 16:22
 * @describe
 */
public interface CustomerService {

    void addOne(Customer customer);

    List<Customer> findAll();

}
