package SiDev.spring_ecomm.repository.productrepository;

import SiDev.spring_ecomm.entity.productentity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByProductCategoryContainingOrProductDescriptionContaining(String productcategory,String productkeyword);
    List<ProductEntity> findByProductPriceLessThan(Double price);
    List<ProductEntity> findByProductRatingMoreThan(Double rating);
}
