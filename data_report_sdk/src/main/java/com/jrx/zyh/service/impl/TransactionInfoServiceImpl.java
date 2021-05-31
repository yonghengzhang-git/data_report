package com.jrx.zyh.service.impl;

import com.jrx.zyh.mapper.TransactionInfoMapper;
import com.jrx.zyh.model.TransactionInfo;
import com.jrx.zyh.service.TransactionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 9:30
 * @describe
 */

@Service
public class TransactionInfoServiceImpl implements TransactionInfoService {

    @Autowired
    private TransactionInfoMapper transactionInfoMapper;

    @Override
    public List<TransactionInfo> findAll() {
        return transactionInfoMapper.selectAll();
    }
}
