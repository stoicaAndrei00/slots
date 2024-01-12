package map.project.slots.Repository;

import map.project.slots.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer , Long> {
    Optional<Customer> findByPersonId(Long personId);

    Optional<Customer> deleteByPersonId(Long personId);
}
