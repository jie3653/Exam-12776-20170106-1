package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Customer;
import com.pojo.CustomerExample;
import com.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/login")
	public String login(String first_name){
		Customer customer = null;
		System.out.println("登录");
		if(first_name != null){
			CustomerExample example = new CustomerExample();
			CustomerExample.Criteria criteria = example.createCriteria();
			criteria.andFirstNameEqualTo(first_name);
			try {
				customer = customerService.selectByExample(example);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(customer != null){
			//登录成功进入film界面
			return "/html/film.html";
		}
		//登录失败返回error界面
		return "/html/error.html";
	}
}
