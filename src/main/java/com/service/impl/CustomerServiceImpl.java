package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.CustomerMapper;
import com.pojo.Customer;
import com.pojo.CustomerExample;
import com.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public Customer selectByExample(CustomerExample example)throws Exception {
		// TODO Auto-generated method stub
		List<Customer> customers = customerMapper.selectByExample(example);
		if(customers != null ){
			return customers.get(0);
		}
		return null;
	}

}
