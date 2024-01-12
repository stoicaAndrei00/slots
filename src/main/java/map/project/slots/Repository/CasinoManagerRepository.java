package map.project.slots.Repository;

import map.project.slots.Model.CasinoManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CasinoManagerRepository extends JpaRepository<CasinoManager , Long> {
    Optional<CasinoManager> findByPersonId(Long personId);

    Optional<CasinoManager> deleteByPersonId(Long personId);
}
