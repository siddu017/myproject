package SiDev.spring_ecomm.service;

import SiDev.spring_ecomm.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> homepageProducts();
    List<ProductDTO> getproductByCategoryOrDescription(String category,String description);
    List<ProductDTO> getproductByPriceLessThan(Double price);
    List<ProductDTO> getproductbyratinggreaterthan(Double rating);
    List<ProductDTO> getproductByName(String name);
}
