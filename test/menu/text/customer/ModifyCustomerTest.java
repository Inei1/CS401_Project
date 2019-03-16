package menu.text.customer;

import Customers.Address;
import Customers.Customer;
import Customers.CustomerList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ModifyCustomerTest {

    private Customer customer;
    private CustomerList customerList;

    @Before
    public void setUp() {
        customerList = new CustomerList();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", 12, testAddress);
        customerList.add(customer);
    }

    @Test
    public void customerModified() {
        ModifyCustomer modify = new ModifyCustomer();
        String inputString = "0\n1\nnewname";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner scanner = new Scanner(inputStream);
        modify.display(scanner, customerList);
        Customer customer2 = customer;
        customer2.setCustomerName("newname");
        assertEquals(customer, customer2);
    }
}