package com.jrx.zyh.mapper;

import com.jrx.zyh.model.Customer;

import java.util.List;

public interface CustomerMapper {

    List<Customer> selectAll();

    int deleteByPrimaryKey(Integer custId);

    int insert(Customer record);

    int insertSelective(Customer record);

//    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Integer custId);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}