package map.project.slots.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

/**
 * class that extends person
 * we will put the many to many relationhip between casino manager and game table
 * this will imply that a manager runs the table
 * the table can be ran by multiple managers and manager can manage more tables
 */
@Entity
@Getter
@Setter
public class CasinoManager extends Person{

    private Date hireDate;

    private float salary;

    @ManyToMany
    private List<GameTable> gameTables;
}
