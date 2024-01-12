package map.project.slots.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * bar is a content table for a many to many relationship between bar and prodcut
 * we will model this with 2 one to many relationships having the many to one
 * annotion for each class
 */
@Data
@Entity
@Getter
@Setter
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long barId;

    private String barName;

    @OneToMany(mappedBy = "bar")
    private List<Product> products;

    @OneToMany(mappedBy = "bar")
    private List<Cashier> cashiers;

    @OneToMany(mappedBy = "bar")
    private List<Customer> customers;

    private int capacity;

    /**
     * we will create an observer pattern where whenever the person bar runs out of a drink
     * the people will change their status
     */

    public void notifyCustomers(){
        this.customers.forEach(Person::updateStatusDissapointed);
    }
}
