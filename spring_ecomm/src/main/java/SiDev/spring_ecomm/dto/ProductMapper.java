package SiDev.spring_ecomm.dto;

import SiDev.spring_ecomm.entity.productentity.ProductEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(ProductEntity entity){
        ProductDTO dto = new ProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setProductName(entity.getProductName());
        dto.setProductCategory(entity.getProductCategory());
        dto.setProductDescription(entity.getProductDescription());
        dto.setProductPrice(entity.getProductPrice());
        dto.setProductRating(entity.getProductRating());
        dto.setProductImageUrl(entity.getProductImageUrl());
        return dto;
    }
    public ProductEntity entity(ProductDTO dto){
        ProductEntity entity = new ProductEntity();
        entity.setProductId(dto.getProductId());
        entity.setProductRating(dto.getProductRating());
        entity.setProductPrice(dto.getProductPrice());
        entity.setProductName(dto.getProductName());
        entity.setProductDescription(dto.getProductDescription());
        entity.setProductCategory(dto.getProductCategory());
        entity.setProductImageUrl(dto.getProductImageUrl());
        return entity;
    }
}
