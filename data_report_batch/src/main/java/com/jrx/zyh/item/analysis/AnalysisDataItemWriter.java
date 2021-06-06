package com.jrx.zyh.item.analysis;

import com.jrx.zyh.model.DailySummary;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;

/**
 * @author Java实习-张永恒
 * @date 2021/6/5 15:53
 * @describe
 */
public class AnalysisDataItemWriter<DailySummary> extends MyBatisBatchItemWriter<DailySummary> {

    public AnalysisDataItemWriter(SqlSessionFactory sqlSessionFactory){
        setSqlSessionFactory(sqlSessionFactory);
        setStatementId("com.jrx.zyh.mapper.DailySummaryMapper.insert");
    }

}
