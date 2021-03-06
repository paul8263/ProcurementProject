package com.paul;

import com.paul.domain.*;
import com.paul.service.def.*;
import com.paul.service.repo.CustomerOrderItemRepo;
import com.paul.service.repo.CustomerOrderRepo;
import com.paul.service.repo.ExpressCompanyRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertFalse;
import java.math.BigDecimal;
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

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CustomerOrderItemService customerOrderItemService;

    @Autowired
    private ExpressCompanyService expressCompanyService;

    @Autowired
    private ExpressPriceService expressPriceService;

    @Autowired
    private ExpressOrderService expressOrderService;

    @Autowired
    private ExpressOrderItemService expressOrderItemService;


    @Before
    public void prepareData() {
//		User
        userService.signUp("paul@123.com", "123456");
        User user1 = userService.findByEmail("paul@123.com");
        Assert.assertNotNull(user1);

        userService.signUp("kate@123.com", "654321");
        User user2 = userService.findByEmail("kate@123.com");
        Assert.assertNotNull(user2);

//		------------------------------------
//		Customer

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

//		------------------------------------
//		Photo ID info

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

//		------------------------------------
//		Customer2

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

//		------------------------------------
//		Product
        Product product1 = new Product();
        product1.setCreateDate(new Date());
        product1.setProductName("MacBook Pro");
        product1.setComment("Comment for product 1");
        product1.setSpecs("13 inch");
        product1.setMarketPrice(new BigDecimal("1699.50"));
        product1.setRetailPrice(new BigDecimal("1899.99"));
        product1.setLastModifyDate(new Date());
        product1.setUser(user1);
        productService.save(product1);

        Product product2 = new Product();
        product2.setCreateDate(new Date());
        product2.setProductName("MacBook Air");
        product2.setComment("Comment for product 2");
        product2.setSpecs("13 inch");
        product2.setMarketPrice(new BigDecimal("1399.50"));
        product2.setRetailPrice(new BigDecimal("1599.99"));
        product2.setLastModifyDate(new Date());
        product2.setUser(user1);
        productService.save(product2);

        user1.getProductList().add(product1);
        user1.getProductList().add(product2);

        Product product3 = new Product();
        product3.setCreateDate(new Date());
        product3.setProductName("Surface Pro 3");
        product3.setComment("Comment for product 3");
        product3.setSpecs("12 inch");
        product3.setMarketPrice(new BigDecimal("1599.50"));
        product3.setRetailPrice(new BigDecimal("1699.99"));
        product3.setLastModifyDate(new Date());
        product3.setUser(user2);
        productService.save(product3);

        Product product4 = new Product();
        product4.setCreateDate(new Date());
        product4.setProductName("Surface Pro 4");
        product4.setComment("Comment for product 4");
        product4.setSpecs("12 inch");
        product4.setMarketPrice(new BigDecimal("2099.95"));
        product4.setRetailPrice(new BigDecimal("2489.50"));
        product4.setLastModifyDate(new Date());
        product4.setUser(user2);
        productService.save(product4);

        Product product5 = new Product();
        product5.setCreateDate(new Date());
        product5.setProductName("iPad");
        product5.setComment("Comment for product 5");
        product5.setSpecs("12 inch");
        product5.setMarketPrice(new BigDecimal("399.95"));
        product5.setRetailPrice(new BigDecimal("499.50"));
        product5.setLastModifyDate(new Date());
        product5.setUser(user2);
        productService.save(product5);

        user2.getProductList().add(product3);
        user2.getProductList().add(product4);

//		------------------------------------
//		Customer order

        CustomerOrder customerOrder1 = new CustomerOrder();
        customerOrder1.setCustomer(customer1);
        customerOrder1.setCreateDate(new Date());
        customerOrder1.setActive(true);
        customerOrderService.saveCustomerOrder(customerOrder1);

        customer1.getCustomerOrderList().add(customerOrder1);

        CustomerOrderItem customerOrderItem1 = new CustomerOrderItem();
        customerOrderItem1.setQuantity(1);
        customerOrderItem1.setProduct(product1);
        customerOrderItem1.setCustomerOrder(customerOrder1);
        customerOrderItemService.save(customerOrderItem1);

        CustomerOrderItem customerOrderItem2 = new CustomerOrderItem();
        customerOrderItem2.setQuantity(1);
        customerOrderItem2.setProduct(product3);
        customerOrderItem2.setCustomerOrder(customerOrder1);
        customerOrderItemService.save(customerOrderItem2);

        customerOrder1.getCustomerOrderItemList().add(customerOrderItem1);
        customerOrder1.getCustomerOrderItemList().add(customerOrderItem2);

//		------------------------------------
//      Express Company
        ExpressCompany expressCompany1 = new ExpressCompany();
        expressCompany1.setActive(true);
        expressCompany1.setUser(user1);
        expressCompany1.setCreateDate(new Date());
        expressCompany1.setName("NEXUS");
        expressCompany1.setAddress("XXX Street");
        expressCompanyService.save(expressCompany1);

        ExpressCompany expressCompany2 = new ExpressCompany();
        expressCompany2.setActive(true);
        expressCompany2.setUser(user1);
        expressCompany2.setCreateDate(new Date());
        expressCompany2.setName("ABC");
        expressCompany2.setAddress("XXX Avenue");
        expressCompanyService.save(expressCompany2);

        ExpressCompany expressCompany3 = new ExpressCompany();
        expressCompany3.setActive(true);
        expressCompany3.setUser(user2);
        expressCompany3.setCreateDate(new Date());
        expressCompany3.setName("CBA");
        expressCompany3.setAddress("XXX Path");
        expressCompanyService.save(expressCompany3);

        user1.getExpressCompanyList().add(expressCompany1);
        user1.getExpressCompanyList().add(expressCompany2);
        user2.getExpressCompanyList().add(expressCompany3);

//		------------------------------------
//      Express Price
        ExpressPrice expressPrice1 = new ExpressPrice();
        expressPrice1.setCreateDate(new Date());
        expressPrice1.setPrice(new BigDecimal("6.50"));
        expressPrice1.setProductType("Milk");
        expressPrice1.setExpressCompany(expressCompany1);
        expressPriceService.save(expressPrice1);

        ExpressPrice expressPrice2 = new ExpressPrice();
        expressPrice2.setCreateDate(new Date());
        expressPrice2.setPrice(new BigDecimal("6.50"));
        expressPrice2.setProductType("Milk");
        expressPrice2.setExpressCompany(expressCompany1);
        expressPriceService.save(expressPrice2);

        expressCompany1.getExpressPriceList().add(expressPrice1);
        expressCompany1.getExpressPriceList().add(expressPrice2);

//		------------------------------------
//      Express order
        ExpressOrder expressOrder1 = new ExpressOrder();
        expressOrder1.setCustomer(customer1);
        expressOrder1.setDelivered(false);
        expressOrder1.setOrderNumber("123456");
        expressOrder1.setCreateDate(new Date());
        expressOrder1.setDeliveredDate(new Date());
        expressOrder1.setSendDate(new Date());
        expressOrder1.setTotalCost(new BigDecimal("20.5"));
        expressOrder1.setTotalWeight(new BigDecimal("4.0"));
        expressOrderService.save(expressOrder1);

        ExpressOrder expressOrder2 = new ExpressOrder();
        expressOrder2.setCustomer(customer1);
        expressOrder2.setDelivered(false);
        expressOrder2.setOrderNumber("123456");
        expressOrder2.setCreateDate(new Date());
        expressOrder2.setDeliveredDate(new Date());
        expressOrder2.setSendDate(new Date());
        expressOrder2.setTotalCost(new BigDecimal("20.5"));
        expressOrder2.setTotalWeight(new BigDecimal("4.0"));
        expressOrderService.save(expressOrder2);

        customer1.getExpressOrderList().add(expressOrder1);
        customer1.getExpressOrderList().add(expressOrder2);

//		------------------------------------
//      Express order item
        ExpressOrderItem expressOrderItem1 = new ExpressOrderItem();
        expressOrderItem1.setExpressOrder(expressOrder1);
        expressOrderItem1.setProduct(product1);
        expressOrderItem1.setQuantity(5);
        expressOrderItemService.save(expressOrderItem1);

        ExpressOrderItem expressOrderItem2 = new ExpressOrderItem();
        expressOrderItem2.setExpressOrder(expressOrder1);
        expressOrderItem2.setProduct(product2);
        expressOrderItem2.setQuantity(5);
        expressOrderItemService.save(expressOrderItem2);

        expressOrder1.getExpressOrderItemList().add(expressOrderItem1);
        expressOrder1.getExpressOrderItemList().add(expressOrderItem2);

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
    public void deleteUserTest() {
        User user = userService.findByEmail("paul@123.com");
        userService.deleteUser(user);
        Assert.assertEquals(customerService.findAll().size(), 2);
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

    @Transactional
    @Test
    public void productTest() {
        User user = userService.findByEmail("paul@123.com");
        Assert.assertNotNull(user);
        List<Product> productList = user.getProductList();
        Assert.assertEquals(productList.size(), 2);

        productList = productService.findAll();
        Assert.assertEquals(productList.size(), 5);

        productList = productService.findAll(user);
        Assert.assertEquals(productList.size(), 2);

        Page<Product> productPage = productService.findAll(new PageRequest(0, 2));
        Assert.assertEquals(productPage.getTotalElements(), 5);
        Assert.assertEquals(productPage.getTotalPages(), 3);

        productPage = productService.findAll(user, new PageRequest(0, 2));
        Assert.assertEquals(productPage.getTotalElements(), 2);
        Assert.assertEquals(productPage.getTotalPages(), 1);

        Assert.assertEquals(productService.findAll().get(4).getMarketPrice(), new BigDecimal("399.95"));
        Product product = productService.findAll().get(4);
		productService.delete(product);
		Assert.assertEquals(productService.findAll().size(), 4);
    }

    @Transactional
    @Test
    public void customerOrderTest() {
        Customer customer = customerService.findByFullName("Paul", "Zhang").get(0);
        List<CustomerOrder> customerOrderList = customer.getCustomerOrderList();
        Assert.assertEquals(customerOrderList.size(), 1);
        Assert.assertEquals(customerOrderList.get(0).getCustomerOrderItemList().size(), 2);
        Assert.assertEquals(customerOrderList.get(0).getCustomerOrderItemList().get(0).getQuantity(), 1);

        Page<CustomerOrder> customerOrderPage = customerOrderService.findAllByCustomer(customer, new PageRequest(0, 2));
        Assert.assertEquals(customerOrderPage.getTotalElements(), 1);

        customerOrderPage = customerOrderService.findAllByCustomer(true, customer, new PageRequest(0, 2));
        Assert.assertEquals(customerOrderPage.getTotalElements(), 1);

        customerOrderList = customerOrderService.findAllByCustomer(customer);
        Assert.assertEquals(customerOrderList.size(), 1);
        CustomerOrder customerOrder = customerOrderList.get(0);
        customerOrderService.setActiveState(customerOrder, false);
        customerOrderList = customerOrderService.findAllByCustomer(true, customer);
        Assert.assertEquals(customerOrderList.size(), 0);
        customerOrderService.setActiveState(customerOrder, true);

		Assert.assertEquals(customerOrderService.findAllByCustomer(customer).size(), 1);
		customerOrder = customerOrderService.findAllByCustomer(customer).get(0);
		customerOrderService.deleteCustomerOrder(customerOrder);
		Assert.assertEquals(customerOrderService.findAllByCustomer(customer).size(), 0);
    }

    @Transactional
    @Test
    public void customerOrderItemTest() {
        Customer customer = customerService.findByFullName("Paul", "Zhang").get(0);
        CustomerOrder customerOrder = customerOrderService.findAllByCustomer(customer).get(0);
        Assert.assertEquals(customerOrder.getCustomerOrderItemList().size(), 2);

        Assert.assertEquals(customerOrderItemService.findAll(customerOrder).size(), 2);
        CustomerOrderItem customerOrderItem = customerOrderItemService.findAll(customerOrder).get(0);
        long id = customerOrderItem.getId();
        Assert.assertEquals(customerOrderItem, customerOrderItemService.findById(id));

        customerOrderItem = customerOrderItemService.findAll(customerOrder).get(0);
        customerOrderItemService.delete(customerOrderItem);
        Assert.assertEquals(customerOrderItemService.findAll(customerOrder).size(), 1);
    }

    @Transactional
    @Test
    public void expressCompanyTest() {
        User user = userService.findByEmail("paul@123.com");
        List<ExpressCompany> expressCompanyList = expressCompanyService.findAll(user);
        Assert.assertEquals(expressCompanyList.size(), 2);

        long expressCompanyId = expressCompanyList.get(0).getId();
        ExpressCompany expressCompany = expressCompanyService.findById(expressCompanyId);
        expressCompany.setActive(false);
        expressCompanyService.save(expressCompany);

        expressCompanyList = expressCompanyService.findAll(false, user);
        Assert.assertEquals(expressCompanyList.size(), 1);

        Page<ExpressCompany> expressCompanyPage = expressCompanyService.findAll(user, new PageRequest(0, 2));
        Assert.assertEquals(expressCompanyPage.getTotalElements(), 2);

        expressCompanyPage = expressCompanyService.findAll(false, user, new PageRequest(0, 2));
        Assert.assertEquals(expressCompanyPage.getTotalElements(), 1);

        expressCompany = expressCompanyService.findById(expressCompanyId);
        expressCompanyService.delete(expressCompany);
        Assert.assertEquals(expressCompanyService.findAll(user).size(), 1);
    }

    @Transactional
    @Test
    public void expressPriceTest() {
        User user = userService.findByEmail("paul@123.com");
        ExpressCompany expressCompany = expressCompanyService.findAll(user).get(0);

        List<ExpressPrice> expressPriceList = expressCompany.getExpressPriceList();
        Assert.assertEquals(expressPriceList.size(), 2);

        expressPriceList = expressPriceService.findAll(expressCompany);
        Assert.assertEquals(expressPriceList.size(), 2);

        Page<ExpressPrice> expressPricePage = expressPriceService.findAll(expressCompany, new PageRequest(0, 2));
        Assert.assertEquals(expressPricePage.getTotalElements(), 2);

        ExpressPrice expressPrice = expressPriceService.findAll(expressCompany).get(0);
        long id = expressPrice.getId();
        Assert.assertEquals(expressPrice, expressPriceService.findById(id));

        expressPrice = expressPriceService.findAll(expressCompany).get(0);
        expressPriceService.delete(expressPrice);
        Assert.assertEquals(expressPriceService.findAll(expressCompany).size(), 1);
    }

    @Transactional
    @Test
    public void expressOrderTest() {
        Customer customer = customerService.findByFullName("Paul", "Zhang").get(0);
        List<ExpressOrder> expressOrderList = customer.getExpressOrderList();
        Assert.assertEquals(expressOrderList.size(), 2);

        expressOrderList = expressOrderService.findAll(customer);
        Assert.assertEquals(expressOrderList.size(), 2);

        ExpressOrder expressOrder = expressOrderList.get(0);
        expressOrderService.setDelivered(expressOrder, true);
        Assert.assertEquals(expressOrderService.findAll(customer, true).size(), 1);

        long id = expressOrder.getId();
        Assert.assertEquals(expressOrder, expressOrderService.findById(id));

        Page<ExpressOrder> expressOrderPage = expressOrderService.findAll(customer, new PageRequest(0, 2));
        Assert.assertEquals(expressOrderPage.getTotalElements(), 2);
        Assert.assertEquals(expressOrderPage.getTotalPages(), 1);

        expressOrderPage = expressOrderService.findAll(customer, false, new PageRequest(0, 2));
        Assert.assertEquals(expressOrderPage.getTotalElements(), 1);
        Assert.assertEquals(expressOrderPage.getTotalPages(), 1);

        expressOrderService.delete(expressOrder);
        Assert.assertEquals(expressOrderService.findAll(customer).size(), 1);

    }

    @Transactional
    @Test
    public void expressOrderItemTest() {
        Customer customer = customerService.findByFullName("Paul", "Zhang").get(0);
        List<ExpressOrder> expressOrderList = customer.getExpressOrderList();
        ExpressOrder expressOrder = expressOrderList.get(0);
        List<ExpressOrderItem> expressOrderItemList = expressOrder.getExpressOrderItemList();
        Assert.assertEquals(expressOrderItemList.size(), 2);

        expressOrderItemList = expressOrderItemService.findAll(expressOrder);
        Assert.assertEquals(expressOrderItemList.size(), 2);

        ExpressOrderItem expressOrderItem = expressOrderItemList.get(0);
        long id = expressOrderItem.getId();
        Assert.assertEquals(expressOrderItem, expressOrderItemService.findById(id));

        Page<ExpressOrderItem> expressOrderItemPage = expressOrderItemService.findAll(expressOrder, new PageRequest(0, 2));
        Assert.assertEquals(expressOrderItemPage.getTotalElements(), 2);

        expressOrderItemService.delete(expressOrderItem);
        Assert.assertEquals(expressOrderItemService.findAll(expressOrder).size(), 1);
    }

}
