package com.jrx.zyh.mapper;

import com.jrx.zyh.model.Customer;
import org.apache.ibatis.annotations.Param;

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

    String selectCustNameById(Integer custId);

    List<Customer> selectByCondition(@Param("pageNum") Integer pageNum,
                                     @Param("name") String name,
                                     @Param("custId") Integer custId);

    Integer countByCondition(
                             @Param("name") String name,
                             @Param("custId") Integer custId);
}