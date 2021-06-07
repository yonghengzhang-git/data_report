package com.jrx.zyh.step;

import com.jrx.zyh.item.create.CreateDataItemReader;
import com.jrx.zyh.item.create.CreateDataItemWriter;
import com.jrx.zyh.model.Customer;
import com.jrx.zyh.model.TransactionInfo;
import com.jrx.zyh.util.RandomDataUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 21:05
 * @describe
 */
@Configuration
public class CreateDataStepConfig {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 模拟生成客户信息的step
     * @return
     */
    @Bean
    public Step createCustStep(){
        return stepBuilderFactory.get("createCustStep")
                .<Customer,Customer>chunk(10)
                .reader(new CreateDataItemReader<Customer>(RandomDataUtil.customerList))
                .writer(createCustDataWriter())
                .build();
    }

    /**
     * 模拟生成交易记录的step
     * @return
     */
    @Bean
    public Step createTranStep(){
        return stepBuilderFactory.get("createTranStep")
                .<TransactionInfo,TransactionInfo>chunk(10)
                .reader(new CreateDataItemReader<TransactionInfo>(RandomDataUtil.randomTranInfoRange("2021-1-1","2021-6-1")))
                .writer(createTranDataWriter())
                .build();
    }

    /**
     * 客户信息批量写入数据库
     * @return
     */
    @Bean
    public CreateDataItemWriter<Customer> createCustDataWriter() {
        return new CreateDataItemWriter<>(sqlSessionFactory,Customer.class);
    }

    /**
     * 交易信息批量写入数据库
     * @return
     */
    @Bean
    public CreateDataItemWriter<TransactionInfo> createTranDataWriter(){
        return new CreateDataItemWriter<>(sqlSessionFactory,TransactionInfo.class);
    }

}
