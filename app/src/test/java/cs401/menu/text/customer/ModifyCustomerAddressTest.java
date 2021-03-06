package cs401.menu.text.customer;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ModifyCustomerAddressTest {

    private Customer customer;
    private CustomerList customerList;

    @Before
    public void setUp() {
        customerList = new CustomerList();
        Address testAddress = new Address("1234", "5678", "abc", "def");
        customer = new Customer("name", "12", testAddress);
        customerList.add(customer);
    }

    @Test
    public void addressModified() {
        String inputString = "street1\ncity2\nstate3\nzip4";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        Scanner scanner = new Scanner(inputStream);
        ModifyCustomerAddress modifyAddress = new ModifyCustomerAddress(customer);
        Address newAddress = new Address("street1", "city2", "state3", "zip4");
        modifyAddress.display(scanner, customerList);
        assertEquals(customer.getAddress().toString(), newAddress.toString());
    }

}