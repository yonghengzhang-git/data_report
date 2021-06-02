package com.jrx.zyh.item.create;

import com.jrx.zyh.model.Customer;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;

/**
 * @author Java实习-张永恒
 * @date 2021/6/1 22:00
 * @describe
 */
public class CreateDataItemWriter<T> extends MyBatisBatchItemWriter<T> {
    public CreateDataItemWriter(SqlSessionFactory sqlSessionFactory,Class clazz) {
        setSqlSessionFactory(sqlSessionFactory);
        setStatementId("com.jrx.zyh.mapper."+clazz.getSimpleName()+"Mapper.insertSelective");
    }
}
