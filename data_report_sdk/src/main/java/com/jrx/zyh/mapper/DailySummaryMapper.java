package com.jrx.zyh.mapper;

import com.jrx.zyh.model.DailySummary;

import java.util.List;

public interface DailySummaryMapper {

    List<DailySummary> selectAll();

    int deleteByPrimaryKey(Integer sId);

    int insert(DailySummary record);

    int insertSelective(DailySummary record);

//    List<DailySummary> selectByExample(DailySummaryExample example);

    DailySummary selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(DailySummary record);

    int updateByPrimaryKey(DailySummary record);
}