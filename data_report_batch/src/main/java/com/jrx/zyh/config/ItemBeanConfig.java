package com.jrx.zyh.config;

import com.jrx.zyh.model.Customer;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 21:24
 * @describe
 */
@Configuration
public class ItemBeanConfig {

    @Bean("createdDataItemWriter")
    public ItemWriter<Customer> createdDataItemWriter(){
        MyBatisBatchItemWriter<Customer> writer = new MyBatisBatchItemWriter<>();
        return writer;
    }

}
