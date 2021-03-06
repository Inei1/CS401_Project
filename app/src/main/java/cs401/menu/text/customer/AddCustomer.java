package cs401.menu.text.customer;

import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.menu.MenuItem;

import java.util.Scanner;

/**
 * add a customer to the customer list
 * @author Neil Moon
 */
public class AddCustomer implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        System.out.println("input the customer name");
        scanner.skip("\n");
        String customerName = scanner.nextLine();
        System.out.println("input the customer id");
        String customerId =  scanner.nextLine();
        System.out.println("input the street address");
        String streetAddress = "";
        streetAddress = scanner.nextLine();
        System.out.println("input the city address");
        String cityAddress = scanner.nextLine();
        System.out.println("input the state address");
        String stateAddress = scanner.nextLine();
        System.out.println("input the zip address");
        String zipAddress = scanner.nextLine();
        Address customerAddress = new Address(streetAddress, cityAddress, stateAddress, zipAddress);
        Customer newCustomer = new Customer(customerName, customerId, customerAddress);
        // modifying the list here modifies it outside this function
        addCustomer(newCustomer, customerList);
    }

    /**
     * add the given customer to the list
     * @param customer customer to add
     * @param customerList list to add to
     */
    private void addCustomer(Customer customer, CustomerList customerList) {
        customerList.add(customer);
    }
}
