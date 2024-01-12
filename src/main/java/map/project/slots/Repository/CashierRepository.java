package map.project.slots.Repository;

import map.project.slots.Model.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CashierRepository extends JpaRepository<Cashier , Long> {
    Optional<Cashier> findByPersonId(Long personId);

    Optional<Cashier> deleteByPersonId(Long personId);
}
