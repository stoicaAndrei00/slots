package map.project.slots.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer extends Person{

    private int loyaltyPoints;

    private float totalSpendings;

    @OneToMany(mappedBy = "customer")
    private List<CustomerSlotRecords> slotRecords;

    @ManyToOne
    @JoinColumn(name = "barId")
    private Bar bar;
}
