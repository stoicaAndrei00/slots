package map.project.slots.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class CustomerSlotRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "personId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "slotId")
    private Slot slot;

    private float winning;

}
