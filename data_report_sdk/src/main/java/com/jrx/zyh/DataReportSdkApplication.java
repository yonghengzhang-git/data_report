package com.jrx.zyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Java实习-张永恒
 * @date 2021/5/30 9:55
 * @describe  sdk启动类
 */

@SpringBootApplication
@MapperScan("com.jrx.zyh.mapper")
public class DataReportSdkApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataReportSdkApplication.class,args);
    }
}
