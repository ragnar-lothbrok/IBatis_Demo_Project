package com.billing.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.billing.model.Customer;

public class CustomerDAO {
	
	@SuppressWarnings("unchecked")
	public List<Customer> selectAllCustomers(){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Customer> list = session.selectList("CustomerMapper.getAllCustomers");
			return list;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public Customer selectCustomerById(int customerId){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Customer customer = (Customer) session.selectOne("CustomerMapper.getCustomerById",customerId);
			return customer;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public void insertCustomer(Customer customer){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("CustomerMapper.insertCustomer",customer);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void updateCustomer(Customer customer){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("CustomerMapper.updateCustomer", customer);
			session.commit();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteCustomer(int customerId){

		SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("CustomerMapper.deleteCustomer", customerId);
			session.commit();
		} finally {
			session.close();
		}
	}	
}
