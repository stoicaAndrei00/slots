package map.project.slots.ObserverTest;

import jakarta.inject.Inject;
import map.project.slots.Model.Bar;
import map.project.slots.Model.Customer;
import map.project.slots.Model.Exceptions.ProductException;
import map.project.slots.Model.Product;
import map.project.slots.Model.Status;
import map.project.slots.Repository.ProductRepository;
import map.project.slots.Service.ProductService;
import map.project.slots.Service.ProviderService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ObserverTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ObserverTest() throws ProductException {

        Bar bar = new Bar();
        bar.setBarId(1L);
        bar.setCapacity(12);
        bar.setBarName("Caro");

        Product product = new Product();
        product.setBar(bar);
        product.setQuantity(0);
        product.setProdcutId(1L);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        bar.setCustomers(customerList);

        Mockito.when(this.productRepository.findByProdcutId(1L)).thenReturn(Optional.of(product));
        this.productService.updateProduct(product);

        Assertions.assertEquals(bar.getCustomers().get(0).getStatus() , Status.Dissapointed);
        Assertions.assertEquals(bar.getCustomers().get(1).getStatus() , Status.Dissapointed);
    }
}
