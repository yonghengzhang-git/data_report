package com.jrx.zyh;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 16:24
 * @describe
 */

@SpringBootApplication
@EnableBatchProcessing
public class DataReportBatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataReportBatchApplication.class,args);
    }
}
