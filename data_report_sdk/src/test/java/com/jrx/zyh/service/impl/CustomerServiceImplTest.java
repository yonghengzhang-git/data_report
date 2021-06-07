package com.jrx.zyh.service.impl;

import com.jrx.zyh.model.Customer;
import com.jrx.zyh.model.enums.EducationEnum;
import com.jrx.zyh.model.enums.MarriageEnum;
import com.jrx.zyh.service.ICustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

    @Autowired
    private ICustomerService customerService;

    @Test
    public void test01(){
        List<Customer> all = customerService.findAll();
        System.out.println(all);
        customerService.addOne(new Customer("张三",1, EducationEnum.COLLEGE, MarriageEnum.UNMARRIED,0520,"北京市朝阳区"));
        all = customerService.findAll();
        System.out.println(all);

    }


}