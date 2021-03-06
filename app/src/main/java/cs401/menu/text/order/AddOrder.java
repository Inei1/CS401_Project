package cs401.menu.text.order;

import cs401.Customers.Customer;
import cs401.Customers.CustomerList;
import cs401.Orders.Order;
import cs401.menu.text.customer.DisplayCustomers;
import cs401.menu.MenuItem;

import java.util.Scanner;

/**
 * add an order to a customer
 * @author Neil Moon
 */
public class AddOrder implements MenuItem {

    @Override
    public void display(Scanner scanner, CustomerList customerList) {
        DisplayCustomers.displayNames(customerList);
        System.out.println("input the customer to add an order to");
        int customer = scanner.nextInt();
        System.out.println("enter the item to order");
        scanner.skip("\n");
        String item = scanner.nextLine();
        System.out.println("enter the cost of the item");
        double cost = scanner.nextDouble();
        System.out.println("enter the quantity of the item");
        int quantity = scanner.nextInt();
        System.out.println("enter the invoice number");
        int invoice = scanner.nextInt();
        System.out.println("enter the item's description");
        scanner.skip("\n");
        String description = scanner.nextLine();
        Order order = new Order(item, cost, quantity, invoice, description);
        addOrder(customerList, customer, order);
    }

    /**
     * add an order to the customer
     * @param customerList customer's list
     * @param customerChoice customer number to change
     * @param order order to add
     */
    private void addOrder(CustomerList customerList, int customerChoice, Order order) {
        Customer customer = customerList.getCustomerList().get(customerChoice);
        customerList.remove(customerList.getCustomerList().get(customerChoice));
        customer.addToOrderList(order);
        customerList.add(customer);
    }
}
