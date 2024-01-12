package map.project.slots.UI;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Customer;
import map.project.slots.Model.Dto.CustomerDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Service.BarService;
import map.project.slots.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class CustomerUI {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BarService barService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @ShellMethod(key = "customers")
    public String findAllCustomers() {
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : customerService.findAllCustomers()) {
            customerDtos.add((CustomerDto) proxyAdapter.adapt(customer));
        }
        return customerDtos.toString();
    }

    @ShellMethod(key = "find customer")
    public String findCustomerById(@ShellOption(value = {"customer id"}, help = "customer id") Long customerId) {
        try {
            return proxyAdapter.adapt(this.customerService.findCustomerById(customerId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete customers")
    public String deleteCustomerById(@ShellOption(value = {"customer id"}, help = "customer id") Long customerId) {
        try {
            return proxyAdapter.adapt(this.customerService.deleteCustomerById(customerId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add customer")
    public String addCustomer(@ShellOption(value = {"name"}, help = "customer name") String name,
                              @ShellOption(value = {"email"}, help = "customer email") String email,
                              @ShellOption(value = {"loyalty points"}, help = "customer points") int loyaltyPoints,
                              @ShellOption(value = {"total spendings"}, help = "customer spendings") float spendings,
                              @ShellOption(value = {"bar"}, help = "bar id") Long barId) {
        try {
            Bar bar = this.barService.findBarById(barId);
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setBar(bar);
            customer.setLoyaltyPoints(loyaltyPoints);
            customer.setTotalSpendings(spendings);
            return this.customerService.addCustomer(customer).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update customer")
    public String updateCustomer(@ShellOption(value = {"customer id"}, help = "customer id") Long customerId,
                                 @ShellOption(value = {"name"}, help = "customer name") String name,
                                 @ShellOption(value = {"email"}, help = "customer email") String email,
                                 @ShellOption(value = {"loyalty points"}, help = "customer points") int loyaltyPoints,
                                 @ShellOption(value = {"total spendings"}, help = "customer spendings") float spendings,
                                 @ShellOption(value = {"bar"}, help = "bar id") Long barId){
        try{
            Bar bar = this.barService.findBarById(barId);
            Customer customer = new Customer();
            customer.setPersonId(customerId);
            customer.setName(name);
            customer.setEmail(email);
            customer.setBar(bar);
            customer.setLoyaltyPoints(loyaltyPoints);
            customer.setTotalSpendings(spendings);
            return proxyAdapter.adapt(this.customerService.updateCustomer(customer)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
