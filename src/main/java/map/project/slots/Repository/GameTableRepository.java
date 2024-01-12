package map.project.slots.Repository;

import map.project.slots.Model.GameTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GameTableRepository extends JpaRepository<GameTable , Long> {
    Optional<GameTable> findByGameTableId(Long gameTableId);

    Optional<GameTable> deleteByGameTableId(Long gameTableId);
}
