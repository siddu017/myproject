package SiDev.spring_ecomm.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import SiDev.spring_ecomm.dto.ProductDTO;
import SiDev.spring_ecomm.dto.ProductMapper;
import SiDev.spring_ecomm.entity.productentity.ProductEntity;
import SiDev.spring_ecomm.repository.productrepository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    public ProductServiceImpl(ProductRepository productRepository,ProductMapper productmapper){
        this.productRepository=productRepository;
        this.productMapper=productmapper;
    }
    public List<ProductDTO> homepageProducts() {
        Random rand = new Random();
        List<ProductEntity> entities = new ArrayList<>();
        List<ProductDTO> dtos = new ArrayList<>();

        long count = productRepository.count();
        if (count == 0) {
            return dtos; // no products in DB
        }

        for (int i = 0; i < 20; i++) {
            long randomId = 1 + rand.nextInt((int) count); // safe cast
            ProductEntity entity = productRepository.findByProductId(randomId);
            if (entity != null) {
                entities.add(entity);
            }
        }

        for (ProductEntity entity : entities) {
            dtos.add(productMapper.toDTO(entity));
        }

        return dtos;
    }

    public List<ProductDTO> getproductByName(String name){
        List<ProductEntity> entities = productRepository.findByProductNameContaining(name);
        List<ProductDTO> dtos = new ArrayList<>();
        for(ProductEntity entity : entities){
            dtos.add(productMapper.toDTO(entity));
        }
        return dtos;
    }


    public List<ProductDTO> getproductByCategoryOrDescription(String category,String description){
        if ((category == null || category.trim().isEmpty()) && (description == null || description.trim().isEmpty())) {
            return Collections.emptyList(); // Nothing to search
        }

        List<ProductEntity> entities;
        List<ProductDTO> dtos = new ArrayList<>();

        if (category == null || category.trim().isEmpty()) {
            entities = productRepository.findByProductDescriptionContaining(description);
            for(ProductEntity entity : entities){
                dtos.add(productMapper.toDTO(entity));
            }
        } else if (description == null || description.trim().isEmpty()) {
            entities = productRepository.findByProductCategoryContaining(category);
            for(ProductEntity entity : entities){
                dtos.add(productMapper.toDTO(entity));
            }
        } else {
            //entities = productRepository.findByProductCategoryContainingOrProductDescriptionContaining(category, description);
            entities = productRepository.findByProductCategoryContainingOrProductDescriptionContaining(category, description);
            for (ProductEntity entity : entities) {
                dtos.add(productMapper.toDTO(entity));
            }
        }
        return dtos;
    }
    public List<ProductDTO> getproductByPriceLessThan(Double price){
        List<ProductEntity> entities = productRepository.findByProductPriceLessThan(price);
        List<ProductDTO> dtos = new ArrayList<>();
        for(ProductEntity entity : entities){
            dtos.add(productMapper.toDTO(entity));
        }
        return dtos;
    }
    public List<ProductDTO> getproductbyratinggreaterthan(Double rating) {

        List<ProductEntity> entities = productRepository.findByProductRatingGreaterThan(rating);
        List<ProductDTO> dtos = new ArrayList<>();
        for (ProductEntity entity : entities) {
            dtos.add(productMapper.toDTO(entity));
        }
        return dtos;
    }

}
