package map.project.slots.Controller;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Customer;
import map.project.slots.Model.Dto.CustomerDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Service.BarService;
import map.project.slots.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private BarService barService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @GetMapping("/customers")
    public List<CustomerDto> findCustomers(){
        List<CustomerDto> customerDtos = new ArrayList<>();
        for(Customer customer : this.customerService.findAllCustomers()){
            customerDtos.add((CustomerDto) proxyAdapter.adapt(customer));
        }
        return customerDtos;
    }

    @GetMapping("/find-customer")
    public CustomerDto findCustomerById(@RequestParam Long customerId){
        try {
            return (CustomerDto) proxyAdapter.adapt(this.customerService.findCustomerById(customerId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("delete-customer")
    public CustomerDto deleteCustomer(@RequestParam Long customerId){
        try {
            return (CustomerDto) proxyAdapter.adapt(this.customerService.deleteCustomerById(customerId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-customer")
    public CustomerDto addCustomer(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam int loyaltyPoints,
                                   @RequestParam float totalSpendings,
                                   @RequestParam Long barId){
        try {
            Bar bar = this.barService.findBarById(barId);
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setLoyaltyPoints(loyaltyPoints);
            customer.setTotalSpendings(totalSpendings);
            customer.setBar(bar);
            return (CustomerDto) proxyAdapter.adapt(this.customerService.addCustomer(customer));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @PostMapping("/update-customer")
    public CustomerDto updateCustomer(@RequestParam Long customerId,
                                      @RequestParam String name,
                                      @RequestParam String email,
                                      @RequestParam int loyaltyPoints,
                                      @RequestParam float totalSpendings,
                                      @RequestParam Long barId){
        try {
            Bar bar = this.barService.findBarById(barId);
            Customer customer = new Customer();
            customer.setPersonId(customerId);
            customer.setName(name);
            customer.setEmail(email);
            customer.setLoyaltyPoints(loyaltyPoints);
            customer.setTotalSpendings(totalSpendings);
            customer.setBar(bar);
            return (CustomerDto) proxyAdapter.adapt(this.customerService.updateCustomer(customer));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

