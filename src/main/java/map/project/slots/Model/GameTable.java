package map.project.slots.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class GameTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gameTableId;

    private String title;

    private String type;

    private int capacity;

    @ManyToOne
    @JoinColumn(name = "providerId")
    private Provider provider;

    @ManyToMany
    private List<CasinoManager> casinoManagers;
}
