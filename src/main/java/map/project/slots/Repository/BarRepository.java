package map.project.slots.Repository;

import map.project.slots.Model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * repository layer for our Bar class
 * we will implement the method find by id
 * delete
 */
@Repository
public interface BarRepository extends JpaRepository<Bar, Long> {
    Optional<Bar> findByBarId(Long barId);

    Optional<Bar> deleteByBarId(Long barId);
}
