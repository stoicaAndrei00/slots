package map.project.slots.Repository;

import map.project.slots.Model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProviderRepository extends JpaRepository<Provider , Long> {
    Optional<Provider> findByProviderId(Long providerId);
    Optional<Provider> deleteByProviderId(Long providerId);
}
