package map.project.slots.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * cashier is a class that extends the person class
 */
@Entity
@Getter
@Setter
public class Cashier extends Person{

    private float salary;

    @ManyToOne
    @JoinColumn(name = "barId")
    private Bar bar;

}
