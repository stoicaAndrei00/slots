package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.Customer;
import map.project.slots.Model.Exceptions.CustomerException;
import map.project.slots.Repository.CustomerRepository;
import map.project.slots.Service.Commander.CustomerCommander;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(){
        return this.customerRepository.findAll();
    }

    public Customer findCustomerById(Long customerId) throws CustomerException {
        Optional<Customer> customer = this.customerRepository.findByPersonId(customerId);
        if(customer.isEmpty()){
            throw new CustomerException();
        }
        return customer.get();
    }
    @Transactional
    public Customer deleteCustomerById(Long customerId) throws CustomerException{
        Optional<Customer> customer = this.customerRepository.findByPersonId(customerId);
        if(customer.isEmpty()){
            throw new CustomerException();
        }
        this.customerRepository.deleteByPersonId(customerId);
        return customer.get();
    }

    /**
     * when we add a customer we will init with a commander
     * so we can assure that the customer is added correctly
     * @param customer
     * @return
     */
    public Customer addCustomer(Customer customer){
        CustomerCommander.run(customer);
        this.customerRepository.save(customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer) throws CustomerException {
        Optional<Customer> optionalCustomer = this.customerRepository.findByPersonId(customer.getPersonId());
        if(optionalCustomer.isEmpty()){
            throw new CustomerException();
        }
        this.customerRepository.save(optionalCustomer.get());
        return optionalCustomer.get();
    }

}
