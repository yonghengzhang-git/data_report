package com.jrx.zyh.item.analysis;

import com.jrx.zyh.model.dto.TransactionInfoDTO;
import com.jrx.zyh.model.dto.TransactionInfoMapDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Java实习-张永恒
 * @date 2021/6/5 15:37
 * @describe
 */
public class AnalysisDataItemReader extends MyBatisPagingItemReader<TransactionInfoMapDTO> {

    public AnalysisDataItemReader(SqlSessionFactory sqlSessionFactory, Map<String, Object> map){
        setParameterValues(map);
        setSqlSessionFactory(sqlSessionFactory);
        setQueryId("com.jrx.zyh.mapper.TransactionInfoMapper.selectTranListByDate");
        setPageSize(220);
    }

}
