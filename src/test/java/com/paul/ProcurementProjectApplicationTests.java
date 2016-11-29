package com.paul;

import com.paul.domain.Customer;
import com.paul.domain.User;
import com.paul.service.def.CustomerService;
import com.paul.service.def.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcurementProjectApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Test
	public void contextLoads() {
	}


	@Before
	public void prepareData() {
		userService.signUp("paul@123.com", "123456");
		User user1 = userService.findByEmail("paul@123.com");
		Assert.assertNotNull(user1);

		Customer customer1 = new Customer();
		customer1.setActive(true);
		customer1.setFirstName("Paul");
		customer1.setLastName("Zhang");
		customer1.setCreateDate(new Date());
		customer1.setCountry("Australia");
		customer1.setProvince("NSW");
		customer1.setCity("Sydney");
		customer1.setAddress("123 Kent Street");
		customer1.setComment("This is the comment for Paul");
		customer1.setUser(user1);
		customerService.saveCustomer(customer1);

		Customer customer2 = new Customer();
		customer2.setActive(true);
		customer2.setFirstName("Kate");
		customer2.setLastName("Zhang");
		customer2.setCreateDate(new Date());
		customer2.setCountry("Australia");
		customer2.setProvince("NSW");
		customer2.setCity("Sydney");
		customer2.setAddress("321 Kent Street");
		customer2.setComment("This is the comment for Kate");
		customer2.setUser(user1);
		customerService.saveCustomer(customer2);

		user1.getCustomerList().add(customer1);
		user1.getCustomerList().add(customer2);
	}


	@Test
	public void customerTest() {
		Customer customer = customerService.findAll().get(0);
		Assert.assertEquals(customer.getFirstName(), "Paul");
	}

	@Transactional
	@Test
	public void userTest() {
		User user = userService.findByEmail("paul@123.com");
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getCustomerList().size(), 2);
	}
}
