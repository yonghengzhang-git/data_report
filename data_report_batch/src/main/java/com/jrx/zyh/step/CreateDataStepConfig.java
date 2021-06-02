package com.jrx.zyh.step;

import com.jrx.zyh.item.create.CreateDataItemReader;
import com.jrx.zyh.item.create.CreateDataItemWriter;
import com.jrx.zyh.model.Customer;
import com.jrx.zyh.model.TransactionInfo;
import com.jrx.zyh.util.RandomDataUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean
    public Step createStep(){
        return stepBuilderFactory.get("createStep")
//                .<Customer,Customer>chunk(10)
//                .reader(new CreateDataItemReader<Customer>(RandomDataUtil.customerList))
//                .writer(createCustDataWriter())
                .<TransactionInfo,TransactionInfo>chunk(10)
                .reader(new CreateDataItemReader<TransactionInfo>(RandomDataUtil.randomTranInfoRange("2021-1-1","2021-6-1")))
                .writer(createTranDataWriter())
                .build();
    }

//    @Bean
    public CreateDataItemWriter<Customer> createCustDataWriter() {
        return new CreateDataItemWriter<>(sqlSessionFactory,Customer.class);
    }

    @Bean
    public CreateDataItemWriter<TransactionInfo> createTranDataWriter(){
        return new CreateDataItemWriter<>(sqlSessionFactory,TransactionInfo.class);
    }

}
