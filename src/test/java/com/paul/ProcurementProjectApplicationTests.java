package com.paul;

import com.paul.domain.Customer;
import com.paul.domain.PhotoIDInfo;
import com.paul.domain.User;
import com.paul.service.def.CustomerService;
import com.paul.service.def.PhotoIDInfoService;
import com.paul.service.def.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertFalse;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcurementProjectApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PhotoIDInfoService photoIDInfoService;

	@Test
	public void contextLoads() {
	}


	@Before
	public void prepareData() {
		userService.signUp("paul@123.com", "123456");
		User user1 = userService.findByEmail("paul@123.com");
		Assert.assertNotNull(user1);

		userService.signUp("kate@123.com", "654321");
		User user2 = userService.findByEmail("kate@123.com");
		Assert.assertNotNull(user2);

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

		PhotoIDInfo info1 = new PhotoIDInfo();
		info1.setCreateDate(new Date());
		info1.setComment("Comment for photo ID info 1");
		info1.setPath("/usr/uploaded/1.jpg");
		info1.setCustomer(customer1);
		photoIDInfoService.save(info1);

		PhotoIDInfo info2 = new PhotoIDInfo();
		info2.setCreateDate(new Date());
		info2.setComment("Comment for photo ID info 2");
		info2.setPath("/usr/uploaded/2.jpg");
		info2.setCustomer(customer1);
		photoIDInfoService.save(info2);

		customer1.getPhotoIDInfoList().add(info1);
		customer1.getPhotoIDInfoList().add(info2);

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

		Customer customer3 = new Customer();
		customer3.setActive(true);
		customer3.setFirstName("Mary");
		customer3.setLastName("Green");
		customer3.setCreateDate(new Date());
		customer3.setCountry("Australia");
		customer3.setProvince("NSW");
		customer3.setCity("Sydney");
		customer3.setAddress("123 Kent Street");
		customer3.setComment("This is the comment for Mary");
		customer3.setUser(user2);
		customerService.saveCustomer(customer3);

		Customer customer4 = new Customer();
		customer4.setActive(true);
		customer4.setFirstName("Jim");
		customer4.setLastName("Green");
		customer4.setCreateDate(new Date());
		customer4.setCountry("Australia");
		customer4.setProvince("NSW");
		customer4.setCity("Sydney");
		customer4.setAddress("321 Kent Street");
		customer4.setComment("This is the comment for Jim");
		customer4.setUser(user2);
		customerService.saveCustomer(customer4);

		user2.getCustomerList().add(customer3);
		user2.getCustomerList().add(customer4);
	}


	@Transactional
	@Test
	public void customerTest() {
		Customer customer = customerService.findAll().get(0);
		Assert.assertEquals(customer.getFirstName(), "Paul");
		Assert.assertEquals(customerService.findAll().size(), 4);

		customerService.setActiveState(customer, false);
		List<Customer> customerList = customerService.findAll(false);
		Assert.assertEquals(customerList.size(), 1);

		User user = userService.findByEmail("paul@123.com");
		Assert.assertNotNull(user);
		customerList = customerService.findByUser(user);
		Assert.assertEquals(customerList.size(), 2);

		Page<Customer> customerPage = customerService.findAll(new PageRequest(0, 2));
		Assert.assertEquals(customerPage.getTotalPages(), 2);

		customerPage = customerService.findAll(true, new PageRequest(0, 2));
		Assert.assertEquals(customerPage.getTotalPages(), 2);

		customerList = customerService.findByFullName("Paul", "Zhang");
		Assert.assertEquals(customerList.size(), 1);

		customerList = customerService.findByUserAndFullName(user, "Paul", "Zhang");
		Assert.assertEquals(customerList.size(), 1);

		customerList = customerService.findByUserAndFullName(user, "Mary", "Green");
		Assert.assertEquals(customerList.size(), 0);

		customerList = customerService.findByUser(true, user);
		Assert.assertEquals(customerList.size(), 1);
		Assert.assertEquals(customerList.get(0).isActive(), true);

		customerPage = customerService.findByUser(user, new PageRequest(0, 2));
		Assert.assertEquals(customerPage.getTotalElements(), 2);

		customerPage = customerService.findByUser(false, user, new PageRequest(0, 2));
		Assert.assertEquals(customerPage.getTotalElements(), 1);

		long customerId = customer.getId();
		Assert.assertNotNull(customerService.findById(customerId));

		customerList = customerService.findByFullName("Mary", "Green");
		customerList.forEach(customerService::deleteCustomer);
		Assert.assertEquals(customerService.findAll().size(), 3);
	}

	@Transactional
	@Test
	public void userTest() {
		User user = userService.findByEmail("paul@123.com");
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getCustomerList().size(), 2);

		List<User> userList = userService.findAll();
		Assert.assertEquals(userList.size(), 2);

		Assert.assertTrue(userService.isEmailDuplicated("paul@123.com"));
		Assert.assertFalse(userService.signUp("paul@123.com", "password"));

		Assert.assertFalse(userService.changePassword("notExist@123.com", "123456", "1234567"));
		Assert.assertFalse(userService.changePassword("paul@123.com", "wrongPassword", "123456"));
		Assert.assertTrue(userService.changePassword("paul@123.com", "123456", "654321"));

		userService.setActiveState(user, false);
		Assert.assertFalse(userService.findByEmail("paul@123.com").isActive());

		userList = userService.findAll(true);
		Assert.assertEquals(userList.size(), 1);
		Assert.assertTrue(userList.get(0).isActive());

		Page<User> userPage = userService.findAll(new PageRequest(0, 2));
		Assert.assertEquals(userPage.getTotalPages(), 1);

		userPage = userService.findAll(false, new PageRequest(0, 2));
		Assert.assertEquals(userPage.getTotalElements(), 1);
		Assert.assertEquals(userPage.getTotalPages(), 1);

		userService.signUp("peter@123.com", "123456");
		user = userService.findByEmail("peter@123.com");
		Assert.assertNotNull(user);
		long userId = user.getId();
		user = userService.findById(userId);
		Assert.assertEquals(user.getEmail(), "peter@123.com");

		userService.deleteUser(user);
		user = userService.findByEmail("peter@123.com");
		Assert.assertNull(user);
	}

	@Transactional
	@Test
	public void photoIDInfoTest() {
		Customer customer = customerService.findByFullName("Paul", "Zhang").get(0);
		Assert.assertNotNull(customer);
		List<PhotoIDInfo> photoIDInfoList = customer.getPhotoIDInfoList();
		Assert.assertEquals(photoIDInfoList.size(), 2);
		Assert.assertEquals(photoIDInfoList.get(0).getPath(), "/usr/uploaded/1.jpg");

		photoIDInfoList = photoIDInfoService.findByCustomer(customer);
		Assert.assertEquals(photoIDInfoList.size(), 2);
		Assert.assertEquals(photoIDInfoList.get(0).getPath(), "/usr/uploaded/1.jpg");

		long photoIDInfoId = photoIDInfoList.get(0).getId();
		PhotoIDInfo photoIDInfo = photoIDInfoService.findById(photoIDInfoId);
		Assert.assertNotNull(photoIDInfo);
		Assert.assertEquals(photoIDInfo.getPath(), "/usr/uploaded/1.jpg");

		photoIDInfoService.delete(photoIDInfo);
		photoIDInfoList = photoIDInfoService.findByCustomer(customer);
		Assert.assertEquals(photoIDInfoList.size(), 1);
	}
}
