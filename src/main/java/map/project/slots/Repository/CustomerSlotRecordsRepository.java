package map.project.slots.Repository;

import map.project.slots.Model.CustomerSlotRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerSlotRecordsRepository extends JpaRepository<CustomerSlotRecords , Long> {
    Optional<CustomerSlotRecords> findByRecordId(Long recordId);

    Optional<CustomerSlotRecords> deleteByRecordId(Long recordId);
}
