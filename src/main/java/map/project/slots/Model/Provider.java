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
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long providerId;

    private String name;

    @OneToMany(mappedBy = "provider")
    private List<Slot> slots;

    @OneToMany(mappedBy = "provider")
    private List<GameTable> gameTables;
}
