package com.jrx.zyh.web.controller;

import com.jrx.zyh.model.Customer;
import com.jrx.zyh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Java实习-张永恒
 * @date 2021/5/31 15:22
 * @describe
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/test/find")
    public List<Customer> findAll(){
        return customerService.findAll();
    }

}
