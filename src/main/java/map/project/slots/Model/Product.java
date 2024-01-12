package map.project.slots.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *product entity in our database
 *
 */
@Entity
@Table
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prodcutId;

    private String type;

    private Long price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "barId")
    private Bar bar;
}
