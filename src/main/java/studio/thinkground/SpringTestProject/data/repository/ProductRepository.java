package studio.thinkground.SpringTestProject.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.SpringTestProject.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
