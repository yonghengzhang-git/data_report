package com.jrx.zyh.mapper;

import com.jrx.zyh.model.TransactionInfo;
import com.jrx.zyh.model.dto.TransactionInfoDTO;
import com.jrx.zyh.model.dto.TransactionInfoMapDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TransactionInfoMapper {

    List<TransactionInfo> selectAll();

//    List<TransactionInfoDTO> selectTranListByDate(Date date);
    List<TransactionInfoMapDTO> selectTranListByDate(Date date);

    int deleteByPrimaryKey(Integer transId);

    int insert(TransactionInfo record);

    int insertSelective(TransactionInfo record);

//    List<TransactionInfo> selectByExample(TransactionInfoExample example);

    TransactionInfo selectByPrimaryKey(Integer transId);

    int updateByPrimaryKeySelective(TransactionInfo record);

    int updateByPrimaryKey(TransactionInfo record);
}