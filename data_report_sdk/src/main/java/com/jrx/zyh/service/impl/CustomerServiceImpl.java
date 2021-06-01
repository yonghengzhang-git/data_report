package com.jrx.zyh.service.impl;

import com.jrx.zyh.mapper.CustomerMapper;

import com.jrx.zyh.service.CustomerService;
import com.jrx.zyh.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 16:23
 * @describe
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public void addOne(Customer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.selectAll();
    }
}
