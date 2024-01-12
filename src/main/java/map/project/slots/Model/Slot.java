package map.project.slots.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long slotId;

    private String Title;

    @ManyToOne
    @JoinColumn(name ="providerId")
    private Provider provider;

    @OneToMany(mappedBy = "slot")
    private List<CustomerSlotRecords> slotRecords;
}
