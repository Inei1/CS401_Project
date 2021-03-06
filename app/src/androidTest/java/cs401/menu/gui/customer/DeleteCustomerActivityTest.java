package cs401.menu.gui.customer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.contrib.RecyclerViewActions;
import cs401.Customers.Address;
import cs401.Customers.Customer;
import cs401.R;
import cs401.menu.gui.CustomerListStateManager;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DeleteCustomerActivityTest {

    @Before
    public void setUp() {
        CustomerListStateManager.getInstance().clearList();
        String name = "TestName", street = "TestStreet", city = "TestCity", state = "TestState";
        int id = 1234, zip = 94555;
        Customer customer = new Customer(name, Integer.toString(id), new Address(street, city, state, Integer.toString(zip)));
        CustomerListStateManager.getInstance().addCustomer(customer);
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    activityRule.getActivity().updateView(CustomerListStateManager.getInstance().getCustomerList());
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Rule
    public ActivityTestRule<DeleteCustomerActivity> activityRule = new ActivityTestRule<>(DeleteCustomerActivity.class);

    @Test
    public void testRemove() {
        onView(withId(R.id.deleteCustList)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        assertEquals(0, CustomerListStateManager.getInstance().getCustomerList().getCustomerList().size());
    }
}
