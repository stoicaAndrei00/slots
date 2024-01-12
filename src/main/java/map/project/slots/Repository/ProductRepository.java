package map.project.slots.Repository;

import map.project.slots.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    Optional<Product> findByProdcutId(Long prouctId);

    Optional<Product> deleteByProdcutId(Long productId);
}
