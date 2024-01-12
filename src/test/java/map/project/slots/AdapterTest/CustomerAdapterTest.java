package map.project.slots.AdapterTest;

import map.project.slots.Model.Customer;
import map.project.slots.Model.Dto.Adapter.CustomerAdapter;
import map.project.slots.Model.Dto.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerAdapterTest {

    @Test
    public void adaptToDtoTest(){
        Customer customer = new Customer();
        customer.setPersonId(1L);
        customer.setEmail("toader@gmail.com");
        customer.setName("tudix");
        customer.setTotalSpendings(1500);
        customer.setLoyaltyPoints(44);

        CustomerDto customerDto = new CustomerAdapter().adaptToDto(customer);

        Assertions.assertEquals(customerDto.getCustomerId() , customer.getPersonId());
        Assertions.assertEquals(customerDto.getEmail() , customer.getEmail());
        Assertions.assertEquals(customerDto.getName() , customer.getName());
        Assertions.assertEquals(customerDto.getLoyaltyPoints() , customer.getLoyaltyPoints());
        Assertions.assertEquals(customerDto.getTotalSpendings() , customer.getTotalSpendings());
    }
}
