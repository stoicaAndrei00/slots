package map.project.slots.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * strategy class for all the person classes eg. Cashier Manager Customer
 * all persons have a name and an email
 * they all can be treated as person in some way and this feature will be good
 * for futher statistics about all people from the casino eg. what drinks they like
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;

    protected String name;

    protected String email;

    protected Status status = Status.Happy;

    /**
     * update method for the observer pattern
     */
    public void updateStatusDissapointed(){
        this.status = Status.Dissapointed;
    }
}
