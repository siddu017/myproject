package SiDev.spring_ecomm.controller;

import SiDev.spring_ecomm.dto.ProductDTO;
import SiDev.spring_ecomm.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/filter")
    public List<ProductDTO> getByCategoryOrDescription(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String description
    ) {
        return productService.getproductByCategoryOrDescription(category, description);
    }

    @GetMapping("/homepage")
    public List<ProductDTO> getHomepageProducts() {
        return productService.homepageProducts();
    }

    @GetMapping("/by-name")
    public List<ProductDTO> getByName(@RequestParam String name) {
        return productService.getproductByName(name);
    }

    @GetMapping("/by-price")
    public List<ProductDTO> getByPriceRange(@RequestParam Double price) {
        return productService.getproductByPriceLessThan(price);
    }

    @GetMapping("/by-rating")
    public List<ProductDTO> getByRatingRange(@RequestParam Double rating) {
        return productService.getproductbyratinggreaterthan(rating);
    }
}
