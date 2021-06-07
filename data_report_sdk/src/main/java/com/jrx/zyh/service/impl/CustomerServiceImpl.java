package com.jrx.zyh.service.impl;

import com.jrx.zyh.mapper.CustomerMapper;

import com.jrx.zyh.model.enums.PageInfo;
import com.jrx.zyh.service.ICustomerService;
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
public class CustomerServiceImpl implements ICustomerService {

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

    @Override
    public PageInfo<Customer> findCustomerByCondition(Integer pageNum, String name, Integer custId) {
        PageInfo<Customer> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(pageNum);

        Integer limit = (pageNum-1)*20;
        List<Customer> list = customerMapper.selectByCondition(limit,name,custId);
        pageInfo.setList(list);

        Integer count = customerMapper.countByCondition(name,custId);
        pageInfo.setCount(count);

        Integer pages = count/20 + 1;
        pageInfo.setPages(pages);

        return pageInfo;

    }
}
