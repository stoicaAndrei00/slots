package map.project.slots.Service.Commander;

import map.project.slots.Model.Customer;
import map.project.slots.Model.Status;

/**
 * commander design pattern for the customer class
 * we will use it to correctly init customer on create
 */
public  class CustomerCommander {

    private static void setCustomerStatus(Customer customer){
        customer.setStatus(Status.Excited);
    }

    private static void setCustomerLoyaltyPoints(Customer customer){
        if(customer.getLoyaltyPoints() > 0){
            customer.setLoyaltyPoints(0);
        }
    }

    private static void setCustomerSpendings(Customer customer){
        if(customer.getTotalSpendings() > 1000){
            customer.setTotalSpendings(0);
        }
    }

    public static void run(Customer customer){
        setCustomerLoyaltyPoints(customer);
        setCustomerSpendings(customer);
        setCustomerStatus(customer);
    }
}
