package map.project.slots.CommanderTest;

import map.project.slots.Model.Customer;
import map.project.slots.Model.Status;
import map.project.slots.Repository.CustomerRepository;
import map.project.slots.Service.Commander.CustomerCommander;
import map.project.slots.Service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CustomerCommanderTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void customerCommanderTest(){
        Customer customer = new Customer();
        customer.setName("Vasile");
        customer.setTotalSpendings(30000);
        customer.setEmail("adi@gmail.com");
        customer.setStatus(Status.Dissapointed);
        customer.setPersonId(1L);
        customer.setLoyaltyPoints(300);
        this.customerService.addCustomer(customer);

        Assertions.assertEquals(customer.getStatus() , Status.Excited);
        Assertions.assertEquals(customer.getLoyaltyPoints() , 0);
        Assertions.assertEquals(customer.getTotalSpendings() , 0);
    }
}
