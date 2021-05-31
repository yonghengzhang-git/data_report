package com.jrx.zyh.mapper;

import com.jrx.zyh.model.TransactionInfo;

import java.util.List;

public interface TransactionInfoMapper {

    List<TransactionInfo> selectAll();

    int deleteByPrimaryKey(Integer transId);

    int insert(TransactionInfo record);

    int insertSelective(TransactionInfo record);

//    List<TransactionInfo> selectByExample(TransactionInfoExample example);

    TransactionInfo selectByPrimaryKey(Integer transId);

    int updateByPrimaryKeySelective(TransactionInfo record);

    int updateByPrimaryKey(TransactionInfo record);
}