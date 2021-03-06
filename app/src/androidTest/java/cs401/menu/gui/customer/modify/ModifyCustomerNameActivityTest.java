package cs401.menu.gui.customer.modify;

import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ModifyCustomerNameActivityTest {

    @Before
    public void setUp() {
        CustomerListStateManager.getInstance().clearList();
        String name = "TestName", street = "TestStreet", city = "TestCity", state = "TestState";
        int id = 1234, zip = 94555;
        Customer customer = new Customer(name, Integer.toString(id), new Address(street, city, state, Integer.toString(zip)));
        CustomerListStateManager.getInstance().addCustomer(customer);
        Intent intent = new Intent();
        intent.putExtra("customer", 0);
        activityRule.launchActivity(intent);
    }

    @Rule
    public ActivityTestRule<ModifyCustomerNameActivity> activityRule = new ActivityTestRule<>(ModifyCustomerNameActivity.class, false, false);

    @Test
    public void testRemove() {
        onView(withId(R.id.modify_customer_name)).perform(typeText("NewTestName"), closeSoftKeyboard());
        onView(withId(R.id.menu_save)).perform(click());
        assertEquals("NewTestName", CustomerListStateManager.getInstance().getCustomer(0).getCustomerName());
    }
}
