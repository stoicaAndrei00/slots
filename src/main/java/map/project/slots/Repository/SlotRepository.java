package map.project.slots.Repository;

import map.project.slots.Model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SlotRepository extends JpaRepository<Slot , Long> {
    Optional<Slot> findBySlotId(Long slotId);

    Optional<Slot> deleteBySlotId(Long slotId);
}
