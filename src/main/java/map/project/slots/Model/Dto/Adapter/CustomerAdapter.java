package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.Customer;
import map.project.slots.Model.Dto.CustomerDto;

public class CustomerAdapter implements Adapter<Customer, CustomerDto> {
    @Override
    public CustomerDto adaptToDto(Customer object) {
        return new CustomerDto(object.getPersonId(),
                object.getName(),
                object.getEmail(),
                object.getLoyaltyPoints(),
                object.getTotalSpendings());
    }
}
