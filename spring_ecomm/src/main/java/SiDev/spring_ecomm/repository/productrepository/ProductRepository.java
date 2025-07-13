package SiDev.spring_ecomm.repository.productrepository;

import SiDev.spring_ecomm.entity.productentity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findByProductNameContaining(String name);

    List<ProductEntity> findByProductCategoryContainingOrProductDescriptionContaining(String productcategory,String productkeyword);
    List<ProductEntity> findByProductPriceLessThan(Double price);
    List<ProductEntity> findByProductRatingGreaterThan(Double rating);

    List<ProductEntity> findByProductDescriptionContaining(String description);

    List<ProductEntity> findByProductCategoryContaining(String category);

    ProductEntity findByProductId(Long j);
}
