package com.service;

import com.pojo.Customer;
import com.pojo.CustomerExample;

public interface CustomerService {
	Customer selectByExample(CustomerExample example) throws Exception;
}
