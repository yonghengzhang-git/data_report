package com.jrx.zyh.service.impl;

import com.jrx.zyh.mapper.DailySummaryMapper;
import com.jrx.zyh.model.DailySummary;
import com.jrx.zyh.service.IDailySummaryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 9:31
 * @describe
 */
public class DailySummaryServiceImpl implements IDailySummaryService {

    @Autowired
    private DailySummaryMapper dailySummaryMapper;

    @Override
    public List<DailySummary> findAll() {
        return dailySummaryMapper.selectAll();
    }
}
