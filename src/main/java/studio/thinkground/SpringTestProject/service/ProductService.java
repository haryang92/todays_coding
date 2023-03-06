package studio.thinkground.SpringTestProject.service;

import studio.thinkground.SpringTestProject.data.dto.ProductDto;

public interface ProductService {
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
    ProductDto getProduct(String productId);

}
